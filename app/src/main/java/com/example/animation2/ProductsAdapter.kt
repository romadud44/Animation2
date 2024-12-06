package com.example.animation2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private val products: MutableList<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV: TextView = itemView.findViewById(R.id.listNameTV)
        val priceTV: TextView = itemView.findViewById(R.id.listPriceTV)
        val imageIV: ImageView = itemView.findViewById(R.id.listProductIV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.nameTV.text = product.name
        holder.priceTV.text = product.price.toString()
        holder.imageIV.setImageResource(product.image)
    }
}