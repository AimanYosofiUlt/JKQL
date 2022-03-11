package com.aiman.jkql.Executive;

import android.database.Cursor;

import com.aiman.jkql.Segments.DBColumn;
import com.aiman.jkql.JKDataBase;

public class DB_OrderByHandler {
    JKDataBase JKDataBase;

    public DB_OrderByHandler(JKDataBase JKDataBase) {
        this.JKDataBase = JKDataBase;
    }

    public DB_OrderByHandler orderBy(DBColumn column) {
        return startOrder(column, DBOrder.ASC);
    }

    public DB_OrderByHandler orderBy(DBColumn column, short orderType) {
        return startOrder(column, orderType);
    }

    public DB_OrderByHandler startOrder(DBColumn column, short orderType) {
        String orderTypeStr;

        if (orderType == DBOrder.ASC)
            orderTypeStr = " ASC";
        else
            orderTypeStr = " DESC";

        DB.addToStatement(" , " + column.getName() + orderTypeStr);

        return new DB_OrderByHandler(JKDataBase);
    }

    public Cursor start() {
        return JKDataBase.select(DB.getStatement());
    }
}