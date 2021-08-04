package com.example.newsify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
const val api="1c499d850313446a9fc52502c5ef9cf6"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter=viewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(),"HOME")
        adapter.addFragment(HealthFragment(),"HEALTH")
        adapter.addFragment(SportFragment(),"SPORT")
        adapter.addFragment(TechFragment(),"TECHNOLOGY")
        adapter.addFragment(EnterFragment(),"ENTERTAINMENT")
        adapter.addFragment(ScienceFragment(),"SCIENCE")
        viewpager.adapter=adapter
        tabview.setupWithViewPager(viewpager)



    }




}


