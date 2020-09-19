package com.example.sqlite.sqlite

import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(
    context: Context?,
    name: String? = DATABASE_NAME,
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1,
    errorHandler: DatabaseErrorHandler? = null
) : SQLiteOpenHelper(context, name, factory, version, errorHandler) {
    companion object {
        const val DATABASE_NAME = "PRODUCT"
        const val PRODUCT = "PRODUCT_TABLE"
        const val PRODUCT_NAME = "PRODUCT_NAME"
        const val PRODUCT_PRICE = "PRODUCT_PRICE"
        const val PRODUCT_ID = "ID"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createProduct = "CREATE TABLE $PRODUCT (" +
                "$PRODUCT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$PRODUCT_NAME TEXT," +
                "$PRODUCT_PRICE TEXT)"
        db?.execSQL(createProduct)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $PRODUCT")
    }
}