package com.example.appki1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.security.AccessControlContext
import java.util.logging.LogManager

class DBHelper(val context: Context):SQLiteOpenHelper(context, DATA_BASE_NAME,null,DATA_BASE_VERSION) {
    companion object{
        internal const val DATA_BASE_NAME = "users1.db" //const inicjuje zmienną na etapie kompilacji
        internal const val DATA_BASE_VERSION = 1
        internal const val TABLE_NAME = "users"
        internal const val COL_ID = "id"
        internal const val COL_NAME = "name"
        internal const val COL_SURNAME = "forename" //kontynuuje błędne nazewnictwo z klasy User
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //val CREATE_USERS_TABLE = db!!.execSQL(SQL_CREATE_ENTRIES)
        val CREATE_USERS_TABLE = ("CREATE TABLE IF NOT EXISTS $TABLE_NAME ( $COL_ID INTEGER PRIMARY KEY, $COL_NAME TEXT, $COL_SURNAME  TEXT)")

        db!!.execSQL(CREATE_USERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
    }

    fun addUser(user: User){
        val values = ContentValues()
        values.put(COL_NAME, user.name)
        values.put(COL_SURNAME, user.forename)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
/*
    fun getAllUsers(): Cursor?{
        val db = this.readableDatabase
        return db!!.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
 */
    val allUsers : MutableList<User>
    get() {
        var usersList = mutableListOf<User>()
        val db = this.readableDatabase
        val cursor = db!!.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()){
            do {
                val id = cursor.getLong(cursor.getColumnIndex(COL_ID))
                val name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                val surname = cursor.getString(cursor.getColumnIndex(COL_SURNAME))
                usersList.add(User(name, surname, id))
                Log.d("User ", User(name, surname, id).toString())
            }while(cursor.moveToNext())
        }
        db.close()

        return usersList
    }
}
