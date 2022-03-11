package com.aiman.jk_sql.DBPkj

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.aiman.jkql.Segments.DBColumn

class UserTable(override val context: Context) : AppDatabase(context, "UserTable") {
    val nameCol = DBColumn(this).getStringInstance("name");
    val ageCol = DBColumn(this).getNumericInstance("age");

    override fun onCreate(db: SQLiteDatabase) {
        super.onCreate(db)
    }
}