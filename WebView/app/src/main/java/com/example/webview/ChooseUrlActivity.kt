package com.example.webview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_choose_url.*

class ChooseUrlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_url)

        naver_btn.setOnClickListener {
            val intent = Intent(this@ChooseUrlActivity, MainActivity::class.java)
            intent.apply {
                this.putExtra("네이버", "http://www.naver.com")
            }
            startActivity(intent)
        }

        google_btn.setOnClickListener {
            val intent = Intent(this@ChooseUrlActivity, MainActivity::class.java)
            intent.apply {
                this.putExtra("구글", "http://www.google.com")
            }
            startActivity(intent)
        }
        daum_btn.setOnClickListener {
            val intent = Intent(this@ChooseUrlActivity, MainActivity::class.java)
            intent.apply {
                this.putExtra("다음", "http://www.daum.net")
            }
            startActivity(intent)
        }
        youtube_btn.setOnClickListener {
            val intent = Intent(this@ChooseUrlActivity, MainActivity::class.java)
            intent.apply {
                this.putExtra("유튜브", "http://www.youtube.com")
            }
            startActivity(intent)
        }
    }
}