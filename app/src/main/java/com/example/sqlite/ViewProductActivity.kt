package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlite.adapter.ProductAdapter
import com.example.sqlite.sqlite.ProductDataAccessObject
import kotlinx.android.synthetic.main.activity_view_product.*

class ViewProductActivity : AppCompatActivity() {
    private lateinit var productDataAccessObject: ProductDataAccessObject
    private lateinit var productAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)
        productDataAccessObject = ProductDataAccessObject(this)
        productAdapter = ProductAdapter(productDataAccessObject.getAllData())
        rycProduct.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rycProduct.setHasFixedSize(true)
        rycProduct.adapter = productAdapter

    }
}