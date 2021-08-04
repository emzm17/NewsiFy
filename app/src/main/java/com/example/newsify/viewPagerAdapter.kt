package com.example.newsify

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class viewPagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var mfragment=ArrayList<Fragment>()
    private var mfragementtitle=ArrayList<String>()


    override fun getCount(): Int {
            return mfragment.size
    }

    override fun getItem(position: Int): Fragment {
        return mfragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
         return mfragementtitle[position]
    }
    fun addFragment(fragment: Fragment,title:String){
        mfragment.add(fragment)
        mfragementtitle.add(title)
    }
}