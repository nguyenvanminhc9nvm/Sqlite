package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlite.model.Product
import com.example.sqlite.sqlite.ProductDataAccessObject
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_main.*

class AddProductActivity : AppCompatActivity() {
    private lateinit var productDataAccessObject: ProductDataAccessObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        productDataAccessObject = ProductDataAccessObject(this)
        button.setOnClickListener {
            productDataAccessObject.insert(Product(null,edNameProduct.text.toString(), edPriceProduct.text.toString()))
        }
    }
}