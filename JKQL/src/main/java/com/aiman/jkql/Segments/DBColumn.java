package com.aiman.jkql.Segments;

import com.aiman.jkql.JKDataBase;

public class DBColumn {
    String name, tableName;
    String type;

    public static final String textType = "TEXT";
    public static final String numericType = "NUMERIC";

    public DBColumn(JKDataBase JKDataBase) {
        this.tableName = JKDataBase.getTableName();
    }

    public String getName() {
        return tableName + "." + name;
    }

    public String getColName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public DBColumn getStringInstance(String name) {
        this.name = name;
        type = textType;
        return this;
    }

    public DBColumn getNumericInstance(String name) {
        this.name = name;
        type = numericType;
        return this;
    }
}
