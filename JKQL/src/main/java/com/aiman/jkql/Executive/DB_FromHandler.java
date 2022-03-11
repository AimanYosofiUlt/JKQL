package com.aiman.jkql.Executive;

import com.aiman.jkql.JKDataBase;

public class DB_FromHandler extends DB_SingleFromHandler {

    public DB_FromHandler(JKDataBase JKDataBase) {
        super(JKDataBase);
    }

    public DB_FromHandler from(JKDataBase table) {
        DB.addToStatement(" , " + table.getTableName());
        return new DB_FromHandler(table);
    }
}
