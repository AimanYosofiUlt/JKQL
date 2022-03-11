package com.aiman.jkql.Executive;

import com.aiman.jkql.Segments.DBColumn;
import com.aiman.jkql.JKDataBase;

public class GroubByCode extends WhareCode {
    protected JKDataBase JKDataBase;

    public GroubByCode(JKDataBase JKDataBase) {
        super(JKDataBase);
        this.JKDataBase = JKDataBase;
    }

    public DB_GroubByHandler groubBy(DBColumn column) {
        DB.addToStatement(" GROUP by " + column.getName());
        return new DB_GroubByHandler(JKDataBase);
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

}
