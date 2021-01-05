package com.example.colortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG : String = "로그"
    }

    //데이터 배열 선언
    private var pageItemList = ArrayList<PageItem>()
    private lateinit var myIntroPagerRecyclerAdapter: MyIntroPagerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"MainActivity - onCreate() called")

        previous_btn.setOnClickListener { 
            Log.d(TAG,"MainActivity - 이전 버튼 클릭")
            my_intro_view_pager.currentItem = my_intro_view_pager.currentItem - 1
        }
        next_btn.setOnClickListener {
            Log.d(TAG,"MainActivity - 다음 버튼 클릭")
            my_intro_view_pager.currentItem = my_intro_view_pager.currentItem + 1
        }

        // 상태바 숨기기(wifi, 배터리표시 있는 바)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        
        //데이터 배열을 준비
        pageItemList.add(PageItem(R.color.ord_btn, R.drawable.chillax_break_icon,"안녕하세요!\n"+"어플만드는 김형진입니다!"))
        pageItemList.add(PageItem(R.color.colorBlue, R.drawable.creativity_icon,"어플 가이드\n"+"만드는 방법입니다."))
        pageItemList.add(PageItem(R.color.colorWhite, R.drawable.rating_icon,"너무어렵다"))
        pageItemList.add(PageItem(R.color.colorAccent, R.drawable.login_icon,"그래도 예쁘다"))


        // 어답터 인스턴스 생성
        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)

        my_intro_view_pager.apply {
            adapter = myIntroPagerRecyclerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            dots_indicator.setViewPager2(this)
        }

    }

}