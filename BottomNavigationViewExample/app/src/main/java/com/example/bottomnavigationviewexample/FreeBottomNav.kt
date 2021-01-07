package com.example.bottomnavigationviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_free_bottom_nav.*

class FreeBottomNav : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {

    // 멤버변수들을 선언
    private lateinit var freeChatfragment: free_chatFragment
    private lateinit var freeHomefragment: free_homeFragment
    private lateinit var freeHighlightfragment: free_highlightFragment
    //--> lateinit은 ?를 사용해서 null을 넣어주는 것과 동일한 역할
    // 빈 값을 넣어주는 역할(나중에 넣어주려고)
    
    companion object{
        const val TAG:String = "로그"
    }

    // 화면이 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 메모리에 올라가고 나서 Activity를 보여주기 위해 xml파일을 연결해준다.
        // 이 부분이 Fragment에서는 onCreateView부분이다.
        setContentView(R.layout.activity_free_bottom_nav)

        Log.d(TAG,"FreeBottomNav - onCreate() called")

        // 클릭이 되면 아래의 onNavigationItemSelected()메서드가 실행된다.
        free_bottom_nav.setOnNavigationItemSelectedListener(this)
        
        // 처음 onCreate가 되었을 때 home을 먼저 보여주기 위한 로직(add를 사용)
        // view를 교체할 때는 replace를 쓰지만 첫번째로 올라갈 때는 add를 사용한다.
        freeHomefragment = free_homeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.free_fragements_frame,freeHomefragment).commit()
        
    }

    // 메인에서 버튼이 클릭된 것을 알아야한다 --> 클릭리스너
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        Log.d(TAG,"FreeBottomNav - onNavigationItemSelected() called")
        when(item.itemId){
            R.id.free_menuHome ->{
                Log.d(TAG,"FreeBottomNav - 홈버튼 클릭")
                // 클릭되었을 때 프래그먼트를 보여주는 방법
                freeHomefragment = free_homeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.free_fragements_frame,freeHomefragment).commit()
            }
            R.id.free_chat ->{
                Log.d(TAG,"FreeBottomNav - 채팅버튼 클릭")
                freeChatfragment = free_chatFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.free_fragements_frame,freeChatfragment).commit()
            }
            R.id.free_highlight ->{
                Log.d(TAG,"FreeBottomNav - 전구버튼 클릭")
                freeHighlightfragment = free_highlightFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.free_fragements_frame,freeHighlightfragment).commit()
            }
        }
        return true
    }
}