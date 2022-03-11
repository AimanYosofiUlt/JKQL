package com.aiman.jkql.Executive;

import com.aiman.jkql.JKDataBase;

public class DB_UpdateWhereHandler {
    JKDataBase JKDataBase;
    public DB_FromHandler OR;
    public DB_FromHandler AND;

    public static short ASC = 0, DESC = 1;

    public DB_UpdateWhereHandler(JKDataBase JKDataBase) {
        this.JKDataBase = JKDataBase;
        OR = new DB_FromHandler(JKDataBase);
        AND = new DB_FromHandler(JKDataBase);

        OR.setWhereType(DB_FromHandler.ORTYPE);
        AND.setWhereType(DB_FromHandler.ANDTYPE);
    }

    public void start() {
        JKDataBase.execSql("Update " + JKDataBase.getTableName() + " Set "  +DB.getUpdateStr());
    }
}
