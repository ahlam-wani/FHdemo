package com.example.myapplication
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val COUNT = 3

    override fun getItem(position: Int): Fragment{
               var fragment:Fragment?=null
        when (position) {
            0 -> fragment = BlankFragment()
            1 -> fragment = BlankFragment2()
            2 -> fragment = BlankFragment3()
        }

        return fragment!!
    }

    override fun getCount(): Int {
        return COUNT
    }

}