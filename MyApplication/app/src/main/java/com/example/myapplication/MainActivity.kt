package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finalwork)
        // activity_main은 에뮬레이터에 띄우고 싶은 화면을 의미한다.
        // 그린 화면을 띄우고 싶으면 만든 xml파일 이름을 적어주면 된다.
    }
}