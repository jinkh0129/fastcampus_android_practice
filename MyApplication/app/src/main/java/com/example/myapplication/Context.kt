package com.example.myapplication

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Context : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)
        
        // 사용하는 방법
        val context : Context = this // 자식은 부모의 타입이 될 수 있다. context를 가져오려면 this를 적으면 된다.
        val applicationContext : android.content.Context = getApplicationContext()
    }
}