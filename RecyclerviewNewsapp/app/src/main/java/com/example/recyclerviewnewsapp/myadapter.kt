package com.example.recyclerviewnewsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class myadapter(
    private val newsArrayList: ArrayList<News>,
    private val context: Activity
) : RecyclerView.Adapter<myadapter.ViewHolder>() {

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val headingTitle: TextView = itemView.findViewById(R.id.headingTitle)
        val headingImage: ShapeableImageView = itemView.findViewById(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem, parent, false)
        return ViewHolder(itemView, myListener)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.headingTitle.text = currentItem.newHeading
        holder.headingImage.setImageResource(currentItem.newsImage)
    }
}
