package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listener.* // build.gradle(Module)파일에 id 'kotlin-android-extensions'를 추가하면 된다.

class Listener : AppCompatActivity() {
    var number = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // 뷰를 activity로 가져오는 방법
        // 1) 직접 찾아서 가져온다.
        // val textView : TextView = findViewById(R.id.hello)
        // 2) xml을 import해서 가져온다.


        hello.setOnClickListener {
            Log.d("click","Click") // 사용자가 클릭했을 때 이 부분이 호출되는 것이다. it:View!는 hello를 의미한다.
            hello.setText("안녕하세요")
            // 클릭이 되면 기존의 txt가 "안녕하세요"로 바뀌게 되는 것이다.
            image.setImageResource(R.drawable.female01)
            // 클릭을 하게되면 이미지도 변하게 된다.
            number += 10
            Log.d("number",""+number) // msg부분에 String이 들어가야 하는데 number는 Int형이라서 오류가 난다. 그래서 원래는 toString()을 해주는게 맞지만 로그를 찍을 때는 그냥 간단하게 빈 문자열을 더해준다.
            // ma
        }

        // 정적인 뷰를 그릴 때는 xml을 활용하여 이런 정적인 뷰를 동적으로 바꾸려면 activity에 xml의 뷰를 가져와서 활용하면 된다.
        
        // 뷰를 조작하는 함수들
        // (1) setText
        // (2) setImageResource




        


    }
}