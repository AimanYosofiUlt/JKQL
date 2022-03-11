package com.aiman.jk_sql.DBPkj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aiman.jk_sql.R
import com.aiman.jkql.Executive.DB

class MainActivity : AppCompatActivity() {
    val userTable = UserTable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getUser(name:String){
        val cursor = DB.select(userTable.nameCol)
            .select(userTable.ageCol)
            .from(userTable)
            .where(userTable.nameCol,name)
            .orderBy(userTable.nameCol)
            .start()

        while (cursor.moveToNext()){
            Toast.makeText(this, "Hi ${cursor.getString(0)}", Toast.LENGTH_SHORT).show();
        }
        cursor.close()
    }

    fun addUser(name:String,age:String){
        DB.insert(userTable.nameCol,name)
            .insert(userTable.ageCol,age)
            .inTo(userTable)
    }

    fun updateUser(oldName:String,newName:String){
        DB.set(userTable.nameCol,newName)
            .update(userTable)
            .where(userTable.nameCol,oldName)
            .exec()
    }

    fun deleteUser(name: String){
        DB.delete(userTable).where(userTable.nameCol,name).exec()
    }
}