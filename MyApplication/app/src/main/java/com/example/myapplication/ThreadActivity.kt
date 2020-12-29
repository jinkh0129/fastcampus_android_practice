package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        button.setOnClickListener {
            val runnable : Runnable = object : Runnable{
                override fun run(){
                    // Runnable안에 하고 싶을 일을 적어주고 runnable을 thread에 적어주면 하나의 흐름을 만들 수 있다.
                    Log.d("thread-1","Thread is made")
                }
            }
            val thread : Thread = Thread(runnable) // thread 생성
            // thread를 만들었다고 해서 바로 실행되는 것이 아니라 MainThread에서 실행을 시켜야지 가능하다.
            // 즉, 무엇을 할지는 알고 있으나 하라는 호출을 아직 받지 못한 상태이다. --> .start()를 사용한다.
            thread.start()
        } // -----> thread를 만들어놓고 버튼을 눌렀을 때 실행되도록 하는 것이다.

        // thread를 생성하는 다른 방법(1)
        Thread(object : Runnable{
            override fun run() {
                Log.d("thread-2","Thread is made")
            }
       }).start() // 앱을 켜자마자 바로 실행

      // thread를 생성하는 다른 방법(2)
        Thread(Runnable {
            Thread.sleep(2000) // thread를 잠깐 정지시키는 것이다(괄호 안에 밀리세컨드를 넣어준다. 2000--> 2초)
            Log.d("thread-3","Thread is made")
            runOnUiThread { // MainThread에서 UI부분을 바꿀 수 있도록 해준다.
                button.setBackgroundColor(getColor(R.color.textview_color))
            }
        }).start() // 앱을 켜자마자 바로 실행





    }
}