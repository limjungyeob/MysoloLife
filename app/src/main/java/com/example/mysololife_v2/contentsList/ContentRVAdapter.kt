package com.example.mysololife_v2.contentsList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mysololife_v2.R
import com.example.mysololife_v2.utils.FBAuth
import com.example.mysololife_v2.utils.FBRef

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
       holder.bindItems(items[position],KeyList[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : ContentModel,key : String) {
            val contentTitle = itemView.findViewById<TextView>(R.id.TextArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)
            contentTitle.text = item.title
//            itemView.setOnClickListener {
//                Toast.makeText(context,item.title,Toast.LENGTH_SHORT).show()
//                val intent = Intent(context,ContentShowActivity::class.java)
//                intent.putExtra("url",item.webUrl)
//                itemView.context.startActivity(intent)
//            }
            bookmarkArea.setOnClickListener {
                Log.d("jylim",FBAuth.getUid())
                Toast.makeText(context,key,Toast.LENGTH_SHORT).show()

                FBRef.bookmarkRef.child(FBAuth.getUid()).child(key).setValue("Good")
            }
            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)

        }
    }
}