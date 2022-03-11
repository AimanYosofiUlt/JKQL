package com.aiman.jkql.Segments;

import com.aiman.jkql.JKDataBase;

import java.util.ArrayList;

public  class TableList {
    ArrayList<JKDataBase> tables;
    public TableList()
    {
        tables = new ArrayList<>();
    }

    public void addTable(JKDataBase table)
    {
        tables.add(table);
    }

    public JKDataBase getTable(int index)
    {
        return tables.get(index);
    }

    public int getTablesCount()
    {
        return  tables.size();
    }
}