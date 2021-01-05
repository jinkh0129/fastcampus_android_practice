package com.example.customapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_u_r_l.*

class URLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_r_l)

        web_vw.settings.javaScriptEnabled = true // 웹에서 javascript로 되어있는 부분을 허용
        web_vw.webViewClient = WebViewClient() // 새로운 창이 뜨지 않도록
        web_vw.webChromeClient = WebChromeClient()
        web_vw.loadUrl("https://www.youtube.com/")
    }
}