package com.aiman.jkql.Executive;

import com.aiman.jkql.Segments.DBColumn;
import com.aiman.jkql.JKDataBase;

public class DB_UpdateHandler {
    public DB_UpdateHandler set(DBColumn col, String val) {
        DB.addUpdateStr(col.getColName() + " = '" + val + "'");
        return new DB_UpdateHandler();
    }

    public DB_UpdateHandler set(DBColumn col, double val) {
        DB.addUpdateStr(col.getColName() + " = " + val);
        return new DB_UpdateHandler();
    }

    public DB_UpdateSetHandler update(JKDataBase table) {
        return new DB_UpdateSetHandler(table);
    }


}
