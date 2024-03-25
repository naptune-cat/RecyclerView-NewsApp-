package com.example.newsapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>,var context : Activity): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    private lateinit var myListener: onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setItemClickListener(listener: onItemClickListener){
        myListener = listener
    }
    //to create new view instance
    //when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView, myListener)
    }
    //populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.heading
        holder.hImage.setImageResource(currentItem.image)
    }

    override fun getItemCount(): Int {
      return newsArrayList.size
    }
    //holds view so that a new view is not created everytime
    class MyViewHolder(itemView : View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.TVheading)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)
        //init acts as a constructor used to initialized
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }
}