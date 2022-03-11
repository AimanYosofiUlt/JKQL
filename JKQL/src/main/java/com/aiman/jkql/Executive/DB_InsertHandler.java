package com.aiman.jkql.Executive;

import com.aiman.jkql.Segments.DBColumn;
import com.aiman.jkql.JKDataBase;

public class DB_InsertHandler {

    public DB_InsertHandler insert(DBColumn col, String val) {
        DB.addInsertStr(col.getColName(), "'" + val + "'");
        return new DB_InsertHandler();
    }

    public DB_InsertHandler insert(DBColumn col, double val) {
        DB.addInsertStr(col.getColName(), "" + val);
        return new DB_InsertHandler();
    }

    public void inTo(JKDataBase JKDataBase) {
        JKDataBase.execSql(" Insert Into " + JKDataBase.getTableName()
                + " ( " + DB.getInsertColsStr() + " ) Values ( " + DB.getInsertValuesStr() + ")");
    }
}
