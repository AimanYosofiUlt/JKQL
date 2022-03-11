package com.aiman.jkql.Executive;

import com.aiman.jkql.Segments.DBColumn;

public class DB_SelectHandler extends DB_SingleSelectHandler {
    public DB_SelectHandler select(DBColumn column) {
        DB.addToStatement(" , " + column.getName());
        return new DB_SelectHandler();
    }
}
