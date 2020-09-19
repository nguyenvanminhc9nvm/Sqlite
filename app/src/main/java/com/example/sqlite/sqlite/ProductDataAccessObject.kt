package com.example.sqlite.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.sqlite.model.Product

class ProductDataAccessObject(context: Context) {
    private var db: SQLiteDatabase
    init {
        val dbManager = DBManager(context)
        db = dbManager.writableDatabase
    }

    fun insert(product: Product): Long {
        val values = ContentValues()
        values.put(DBManager.PRODUCT_NAME, product.nameProduct)
        values.put(DBManager.PRODUCT_PRICE, product.priceProduct)
        return db.insert(DBManager.PRODUCT,null,values)
    }

    fun getAllData(): MutableList<Product> {
        val output = arrayListOf<Product>()
        val sql = "SELECT * FROM ${DBManager.PRODUCT}"
        val cursor = db.rawQuery(sql,null)
        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndex(DBManager.PRODUCT_ID))
            val name = cursor.getString(cursor.getColumnIndex(DBManager.PRODUCT_NAME))
            val price = cursor.getString(cursor.getColumnIndex(DBManager.PRODUCT_PRICE))
            output.add(Product(id,name,price))
        }
        return output
    }

    fun delete(product: Product): Int {
        return db.delete(DBManager.PRODUCT, "${DBManager.PRODUCT_NAME}=?",
            arrayOf(product.nameProduct) )
    }
}