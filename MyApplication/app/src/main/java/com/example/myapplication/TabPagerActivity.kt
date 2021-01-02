package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))
        // parameter를 넣어주라는데 왜 suppotrFragmentManager를 넣는거지?
        val pagerAdapter = PagerAdapter(supportFragmentManager,3)
        View_pager.adapter = pagerAdapter

        // Tablayout과 Pager를 연동해주는 작업
        tab_layout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // tab이 클릭됐을 때 --> 탭 순번과 맞는 frag를 보여줘야한다.
                View_pager.setCurrentItem(tab!!.position)
                // 탭을 눌렀을 때 화면이 바뀌도록(**)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        View_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        // 손으로 넘길 때 화면이 바뀌도록(**)

    }
}

//-------Adapter를 만드는 방법------------
/*
어댑터는 Pager를 위한 것이다.
화면을 수평으로 여러개 만들어놓고 1개씩 보여주는 것이다.
 */

class PagerAdapter(
    fragmentManager: FragmentManager, // 수평으로 리스트처럼 보여주는 adapter는 fragment를 사용하겠다는 의미
    val tabCount : Int
):FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment { // item 1개를 찾을 때
        when(position){
            0->{
                return Fragment1()
            }
            1->{
                return Fragment2()
            }
            2->{
                return Fragment3()
            }
            else -> return Fragment1()
        }
    }
    
    override fun getCount(): Int { // item 전체의 사이즈
        return tabCount
    }


}