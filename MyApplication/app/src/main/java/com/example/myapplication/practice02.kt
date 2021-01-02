package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_practice02.*

class practice02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice02)


        val name = intent.getStringExtra("name")
        // practice01에서 보낸 값을 받는 과정
        name_result.setOnClickListener {
            name_result.setText(name)
        }


    }
}