package com.example.sqlite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite.R
import com.example.sqlite.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(val products: MutableList<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ProductViewHolder){
            holder.bind(products[position])
        }
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(product: Product){
            itemView.tvName.text = product.nameProduct
            itemView.tvPrice.text = product.priceProduct
        }
    }

}