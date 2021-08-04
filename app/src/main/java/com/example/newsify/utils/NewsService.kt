package com.example.newsify.utils

import com.example.newsify.modal.Articles
import com.example.newsify.modal.News
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY="1c499d850313446a9fc52502c5ef9cf6"

interface NewsService {
    @GET("top-headlines?apiKey=$API_KEY")
      fun getNews(@Query("country")country:String,
      @Query("pageSize")pageSize:Int):Call<News>


   @GET("top-headlines?apiKey=$API_KEY")
        fun getCategoryNews(
       @Query("country")country: String,
       @Query("category")category: String,
       @Query("pageSize")pageSize:Int):Call<News>



}