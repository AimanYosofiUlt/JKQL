package com.aiman.jkql.Executive;


import com.aiman.jkql.JKDataBase;

public class DB_SingleSelectHandler {
    public DB_SingleFromHandler from(JKDataBase table) {
        DB.addToStatement(" From " + table.getTableName());
        return new DB_SingleFromHandler(table);
    }

}