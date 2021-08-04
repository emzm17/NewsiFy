package com.example.newsify.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsify.R
import com.example.newsify.modal.Articles
import com.example.newsify.modal.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class NewsAdapter(val context:Context,val list: ArrayList<Articles>):RecyclerView.Adapter<NewsViewholder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewholder {
           return NewsViewholder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: NewsViewholder, position: Int) {
        val news=list[position]
         holder.bind(list[position])
         holder.itemView.setOnClickListener {
              val url=news.url
             val builder=CustomTabsIntent.Builder()
             val customTabsIntent=builder.build()
             customTabsIntent.launchUrl( context, Uri.parse(url))
         }
       }

    override fun getItemCount(): Int {
              return list.size
    }



}
class NewsViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(it:Articles)= with(itemView) {
        mainheading.text = it.title
        maincontent.text = it.description
        mauthor.text = it.author
        mdate.text = it.publishedAt
        val imageurl = it.urlToImage
        Glide.with(context).load(imageurl).into(img)

    }

}