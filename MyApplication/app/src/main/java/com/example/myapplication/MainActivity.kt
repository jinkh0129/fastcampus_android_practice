package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
// 이 두부분은 반드시 필요하다고 생각하면 된다.
import android.util.Log
// 코틀린을 할 때는 println으로 확인을 했다면 안드로이드를 만들 때는 log를 사용한다.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrollview13)
        // 레이아웃은 1번만 그리면 된다.
        // activity_main은 에뮬레이터에 띄우고 싶은 화면을 의미한다.
        // 그린 화면을 띄우고 싶으면 만든 xml파일 이름을 적어주면 된다.

        Log.d("Life_cycle","onCreate") // 특정 꼬리표가 달린 기록만 보고싶을 때  tag 를 사용하면 된다
    }

    override fun onStart() {
        super.onStart()
        Log.d("Life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life_cycle","onStop")
    }
    // pause와 stop의 구분은 애매하다. 그래서 그냥 하나의 단계에 몰아서 적어도 된다.

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life_cycle","onDestroy")
    }
}