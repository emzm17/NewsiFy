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
import kotlinx.android.synthetic.main.fragment_enter.*
import kotlinx.android.synthetic.main.fragment_health.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_sport.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EnterFragment : Fragment() {
    lateinit var adapter: NewsAdapter
    private var country="in"
    private var category="entertainment"
    var newslist= ArrayList<Articles>()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? =  inflater.inflate(R.layout.fragment_enter, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pgbarenter.visibility=View.VISIBLE
        rventer.layoutManager=LinearLayoutManager(requireContext())
        adapter= NewsAdapter(requireContext(),newslist)
        rventer.adapter=adapter

        val res=Client.api.getCategoryNews(country,category, 100)
        res.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {

                if(response.isSuccessful){
                    pgbarenter.visibility=View.GONE
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