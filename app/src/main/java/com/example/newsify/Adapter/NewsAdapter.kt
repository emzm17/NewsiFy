package com.example.newsify.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsify.R
import com.example.newsify.WebViewActivity
import com.example.newsify.modal.Articles

import kotlinx.android.synthetic.main.items.view.*
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class NewsAdapter(val context: Context, val list: ArrayList<Articles>):RecyclerView.Adapter<NewsViewholder> ()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewholder {
           return NewsViewholder(LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false))
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: NewsViewholder, position: Int) {
        val news=list[position]
        holder.bind(list[position])
        holder.itemView.sharebtn.setOnClickListener{
            val intent=Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,news.url)
            val c=Intent.createChooser(intent,"Share this Wonderful News")
            context.startActivity(c)
        }
        holder.itemView.setOnClickListener {
            val url=news.url
            val intent=Intent(context,WebViewActivity::class.java)
            intent.putExtra("URL",url)
          context.startActivity(intent)
        }
       }

    override fun getItemCount(): Int {
              return list.size
    }



}
class NewsViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(it: Articles)= with(itemView) {
        mainheading.text = it.title
        if(it.description==null){
            maincontent.text="Can't Display the Content Please had over to Website"
        }
        else{
            maincontent.text=it.description
        }

        if(it.author==null){
            mauthor.text="Unknown Source"
        }
        else{
            mauthor.text=it.author
        }
        val imageurl = it.urlToImage
        Glide.with(context).load(imageurl).into(mainimg)
        val dateTime: ZonedDateTime = ZonedDateTime.parse(it.publishedAt)
        val res = dateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a"))
        mpublishtime.text=res
    }



}