
JKQL  
=====  
[![jitpack](https://jitpack.io/v/MoonXapps/JKQL.svg)](https://jitpack.io/#MoonXapps/JKQL)  

  JKQL fast and efficien library to create SQLite Database and deal with SQL statemen to be like Jave and Kotlin Code inside of android studio
  
  
### Download  

Add below codes to your **Project Setting**  `setting.gradle` file

```gradle  
dependencyResolutionManagement {  
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)  
    repositories {  
		...
        maven { url 'https://jitpack.io' }  
 }}
 ```
Add below codes to your **Module:appname**  `build.gradle` file
```  
dependencies {  
     implementation 'com.github.MoonXapps:JKQL:1.1'
}  
``` 
 

### Prepare

1- Prepare the database by Inheritance of the class `JKDataBase`

```  
open class AppDatabase(open val context: Context, tableName: String) : JKDataBase(context, tableName) {  
    override fun onCreate(db: SQLiteDatabase) {  
        super.onCreate(db)  
        // Here we gona to create the tables
    }  
}
``` 

2- Prepare the Tables 

```  
class UserTable(override val context: Context) : AppDatabase(context, "UserTable") {  
    val nameCol = DBColumn(this).getStringInstance("name");  
    val ageCol = DBColumn(this).getNumericInstance("age");  
  
    override fun onCreate(db: SQLiteDatabase) {  
        super.onCreate(db)  
    }  
}
``` 

3- Prepare of creating the tables by override `onCreate(..)` function inside `JKDataBase`
use `addColumn(...)` then `createTable(db,tableName)` for each table:
```
open class AppDatabase(open val context: Context, tableName: String) : JKDataBase(context, tableName) {  
    override fun onCreate(db: SQLiteDatabase) {  
        super.onCreate(db)  
        val userTable = UserTable(context)  
        addColumn(userTable.nameCol,true,false)  
        addColumn(userTable.ageCol,true,false)  
        createTable(db,userTable.tableName)  
    }  
}
```

> *`addColumn(...)` has three overloading*
1- `addColumn(columnName: DBColumn, AI: boolean)`  : function to create primeryKey Column  and **AI** mean is it  Auto-increment PrimeryKey?  
2- `addColumn(columnName: DBColumn, NN: boolean, U: boolean)` : **NN** is it NotNull? and **U** is it  Unique?
3- `addColumn(columnName: DBColumn, defValue: String)` : **defValue** to set the default value، here the column *Not-Null* and *Not-Uniqe*

### Usage
you can start write SQL statment like a static java\kotlin instance like the following code:

```
val userTable = UserTable(this)  
  
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

```
