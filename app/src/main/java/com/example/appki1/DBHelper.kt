package com.example.appki1

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext

class DBHelper(val context: Context):SQLiteOpenHelper(context, DATA_BASE_NAME,null,DATA_BASE_VERSION) {
    companion object{
        internal const val DATA_BASE_NAME = "users.db"
        internal const val DATA_BASE_VERSION = 1
        internal const val TABLE_NAME = "users"
        internal const val COL_ID = "id"
        internal const val COL_NAME = "name"
        internal const val COL_SURE_NAME = "forename" //kontynuuje błędne nazewnictwo z klasy User
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = db!!.execSQL()
    }
}
