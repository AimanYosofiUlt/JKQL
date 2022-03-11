package com.aiman.jkql.Executive;

import com.aiman.jkql.Segments.DBColumn;
import com.aiman.jkql.JKDataBase;

public class DB_GroubByHandler extends OrderCode {
    private final JKDataBase JKDataBase;

    public DB_GroubByHandler groubBy(DBColumn column) {
        DB.addToStatement(" , " + column.getName());
        return new DB_GroubByHandler(JKDataBase);
    }

    public DB_GroubByHandler(JKDataBase JKDataBase) {
        super(JKDataBase);
        this.JKDataBase = JKDataBase;
    }

    public DB_OrderByHandler orderBy(DBColumn column) {
        DB.addToStatement(" ORDER BY " + column.getName());
        return new DB_OrderByHandler(JKDataBase);
    }


}
