package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_open_url.*

class openUrl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_url)

        naver.setOnClickListener{
            val naver_intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"))
            startActivity(naver_intent)
        }

        daum.setOnClickListener {
            val daum_intent = Intent(Intent.ACTION_VIEW,Uri.parse("http://daum.net"))
            startActivity(daum_intent)
        }
    }
}