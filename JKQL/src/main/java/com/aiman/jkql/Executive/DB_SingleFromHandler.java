package com.aiman.jkql.Executive;

import com.aiman.jkql.JKDataBase;

public class DB_SingleFromHandler extends GroubByCode {
    protected JKDataBase JKDataBase;

    public DB_SingleFromHandler(JKDataBase JKDataBase) {
        super(JKDataBase);
        this.JKDataBase = JKDataBase;
    }
}
