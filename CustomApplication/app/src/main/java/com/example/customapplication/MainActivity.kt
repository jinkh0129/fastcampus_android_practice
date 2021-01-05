package com.example.customapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sub01.*
import kotlinx.android.synthetic.main.sub02.*
import kotlinx.android.synthetic.main.sub03.*
import kotlinx.android.synthetic.main.sub04.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.chullo))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.llama))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.peru))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.coca_tea))

        val pagerAdapter = PagerAdapter(supportFragmentManager,4)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.setCurrentItem(tab!!.position)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))


    }

}

class PagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount : Int
) : FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment{
        when (position) {
            0 -> {
                return Sub01()
            }
            1 -> {
                return Sub02()
            }
            2 -> {
                return Sub03()
            }
            3 -> {
                return Sub04()
            }
            else -> return Sub01()
        }
    }
    override fun getCount(): Int {
        return tabCount
    }
}