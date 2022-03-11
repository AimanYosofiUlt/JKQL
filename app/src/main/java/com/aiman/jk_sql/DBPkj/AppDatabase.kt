package com.aiman.jk_sql.DBPkj

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.aiman.jkql.JKDataBase

open class AppDatabase(open val context: Context, tableName: String) : JKDataBase(context, tableName) {
    override fun onCreate(db: SQLiteDatabase) {
        super.onCreate(db)
        val userTable = UserTable(context)
        addColumn(userTable.nameCol,true,false)
        addColumn(userTable.ageCol,true,false)
        createTable(db,userTable.tableName)
    }
}