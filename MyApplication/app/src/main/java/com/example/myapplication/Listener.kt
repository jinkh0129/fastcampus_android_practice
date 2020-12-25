package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // xml에 있는 뷰를 가져오는 2가지 방법
        //(1) 직접 찾아서 가져온다.
        val textView : TextView = findViewById(R.id.hello)
        // id가 hello인 뷰 중에서 TextView인 애를 액티비티로 가져올 수 있다.
        //(2) 코틀린에서 xml을 import하게 한다.
//        hello.

        textView.setOnClickListener {
            Log.d("click","Click!!")
        }



    }
}