package com.aiman.jkql.Executive;

import com.aiman.jkql.Segments.DBColumn;
import com.aiman.jkql.JKDataBase;

public class DB_WhereHandler extends GroubByCode {
    JKDataBase JKDataBase;
    public DB_FromHandler or;
    public DB_FromHandler and;

    public DB_WhereHandler(JKDataBase JKDataBase) {
        super(JKDataBase);
        this.JKDataBase = JKDataBase;
        or = new DB_FromHandler(JKDataBase);
        and = new DB_FromHandler(JKDataBase);

        or.setWhereType(DB_FromHandler.ORTYPE);
        and.setWhereType(DB_FromHandler.ANDTYPE);
    }

    public DB_GroubByHandler groubBy(DBColumn column) {
        DB.addToStatement(" GROUP by " + column.getName());
        return new DB_GroubByHandler(JKDataBase);
    }

    public DB_OrderByHandler orderBy(DBColumn column) {
        DB.addToStatement(" ORDER BY " + column.getName());
        return new DB_OrderByHandler(JKDataBase);
    }

    public DB_OrderByHandler orderBy(DBColumn column, short orderType) {
        String orderTypeStr;
        if (orderType == DBOrder.ASC)
            orderTypeStr = "ASC";
        else
            orderTypeStr = "DESC";

        DB.addToStatement(" ORDER BY " + column.getName() + " " + orderTypeStr);

        return new DB_OrderByHandler(JKDataBase);
    }

}
