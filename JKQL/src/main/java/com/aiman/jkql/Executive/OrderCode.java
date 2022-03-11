package com.aiman.jkql.Executive;

import android.database.Cursor;
import android.util.Log;

import com.aiman.jkql.JKDataBase;
import com.aiman.jkql.Segments.DBColumn;

public class OrderCode {
    JKDataBase JKDataBase;

    public OrderCode(JKDataBase JKDataBase) {
        this.JKDataBase = JKDataBase;
    }

    public DB_OrderByHandler orderBy(DBColumn column) {
        return startOrder(column, DBOrder.ASC,false);
    }

    public DB_OrderByHandler orderBy(DBColumn column, short orderType) {
        return startOrder(column,orderType,false);
    }

    public DB_OrderByHandler orderByMax(DBColumn column) {
        return startOrder(column, DBOrder.ASC, true);
    }

    public DB_OrderByHandler orderByMax(DBColumn column, short orderType) {
        return startOrder(column, orderType, true);
    }

    public DB_OrderByHandler startOrder(DBColumn column, short orderType, boolean isMax) {
        String orderTypeStr, columnName;

        if (orderType == DBOrder.ASC)
            orderTypeStr = " ASC";
        else
            orderTypeStr = " DESC";

        if (isMax)
            columnName = "Max (" + column.getName() + ")";
        else
            columnName = column.getName();


        DB.addToStatement(" ORDER BY " + columnName + orderTypeStr);

        return new DB_OrderByHandler(JKDataBase);
    }

    public final Cursor start() {
        if (DB.getSqlStmtType().equals(DB.SELECT_STMT))
            return JKDataBase.select(DB.getStatement());
        throw getCondationExption("you can't use start with " + DB.getSqlStmtType() + " Statment");
    }

    public final void exec() {
        JKDataBase.execSql(DB.getStatement());
    }
    private RuntimeException getCondationExption(String message) {
        RuntimeException exception = new RuntimeException();
        Log.e("DBSql Error: ", message, exception);
        return exception;
    }
}
