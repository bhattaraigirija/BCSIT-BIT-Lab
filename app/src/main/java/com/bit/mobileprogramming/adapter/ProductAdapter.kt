package com.bit.mobileprogramming.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bit.mobileprogramming.R
import com.bit.mobileprogramming.model.Product
import com.bumptech.glide.Glide

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val price: TextView = view.findViewById(R.id.tvPrice)
        val image: ImageView = view.findViewById(R.id.ivProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.title.text = product.title
        holder.price.text = "$${product.price}"

        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.image)
    }

    override fun getItemCount(): Int = productList.size
}

