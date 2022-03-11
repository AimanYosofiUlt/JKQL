package com.aiman.jkql.Executive;

import com.aiman.jkql.JKDataBase;

public class DB_DeleteHandler extends WhareCode {
    JKDataBase JKDataBase;

    public DB_DeleteHandler(com.aiman.jkql.JKDataBase JKDataBase) {
        super(JKDataBase);
        this.JKDataBase = JKDataBase;
    }
}
