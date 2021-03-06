package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var new = "0" // 새로 입력했던 값 --> 다시 더할 때는 old가 됨.
        var old = "0" // 이전에 입력했던 값

        number1.setOnClickListener {
            new = new + "1"
            result.setText(new)
        }
        number2.setOnClickListener {
            new = new + "2"
            result.setText(new)
        }
        number3.setOnClickListener {
            new = new + "3"
            result.setText(new)
        }
        number4.setOnClickListener {
            new = new + "4"
            result.setText(new)
        }
        number5.setOnClickListener {
            new = new + "5"
            result.setText(new)
        }
        number6.setOnClickListener {
            new = new + "6"
            result.setText(new)
        }
        number7.setOnClickListener {
            new = new + "7"
            result.setText(new)
        }
        number8.setOnClickListener {
            new = new + "8"
            result.setText(new)
        }
        number9.setOnClickListener {
            new = new + "9"
            result.setText(new)
        }
        number0.setOnClickListener {
            new = new + "0"
            result.setText(new)
        }


        cancel.setOnClickListener {
            var new = "0"
            var old = "0"
            result.setText(old)
        }
        plus.setOnClickListener {
            old = (old.toInt() + new.toInt()).toString()
            // old와 new는 String형이므로 더할 때는 Int로 바꿔서 더해야 한다.
            new = "0"
            // 다음 수를 받을 수 있도록
            result.setText(old)
            // result라는 아이디를 가진 뷰(텍스트뷰)에 old를 표시하도록 함
        }

    }

}