package com.example.mysololife_v2.contentsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mysololife_v2.R

class ContentRVAdapter(val context : Context, val items : ArrayList<ContentModel>,val KeyList : ArrayList<String>) : RecyclerView.Adapter<ContentRVAdapter.ViewHolder>() {

    interface  ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.ViewHolder, position: Int) {
        if(itemClick != null) {
            holder.itemView.setOnClickListener {
                v->itemClick?.onClick(v,position)
            }
        }
       holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : ContentModel) {
            val contentTitle = itemView.findViewById<TextView>(R.id.TextArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)
            contentTitle.text = item.title

            bookmarkArea.setOnClickListener {
                Toast.makeText(context,KeyList.toString(),Toast.LENGTH_SHORT).show()
            }
            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)

        }
    }
}