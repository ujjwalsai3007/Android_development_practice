package com.example.projectapi

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class Myadapter(private val context: Activity, private val productListArray: List<Product>) :
    RecyclerView.Adapter<Myadapter.Myviewholder>() {

    class Myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.productTitle)
        val image: ShapeableImageView = itemView.findViewById(R.id.productImage)
        val rating: TextView = itemView.findViewById(R.id.productRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return Myviewholder(itemView)
    }

    override fun getItemCount(): Int {
        return productListArray.size
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val currentItem = productListArray[position]
        holder.title.text = currentItem.title
        holder.rating.text = "Rating: ${currentItem.rating}" // Bind rating as text
        Picasso.get().load(currentItem.thumbnail).into(holder.image) // Load image
    }
}