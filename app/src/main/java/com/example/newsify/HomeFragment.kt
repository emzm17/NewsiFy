package com.example.newsify

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsify.Adapter.NewsAdapter
import com.example.newsify.modal.Articles
import com.example.newsify.modal.News
import com.example.newsify.utils.Client
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

lateinit var adapter: NewsAdapter
var country:String="in"
    var newslist= ArrayList<Articles>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_home, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      rvhome.layoutManager=LinearLayoutManager(requireContext())
        adapter= NewsAdapter(requireContext(),newslist)
        rvhome.adapter=adapter

        val res=Client.api.getNews(country,100)
        res.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {

                if(response.isSuccessful){
                    response.body()?.let { newslist.addAll(it?.articles) }
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }


    }


