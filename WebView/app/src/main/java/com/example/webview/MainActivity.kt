package com.example.webview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //----------------------------------------------------------------
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        //----------------------------------------------------------------

        val a: String? = intent.getStringExtra("네이버")
        val b = intent.getStringExtra("구글")
        val c = intent.getStringExtra("유튜브")
        val d = intent.getStringExtra("다음")

        if (a == "http://www.naver.com") {
            webView.loadUrl(a)
        } else if (b == "http://www.google.com") {
            webView.loadUrl(b)
        } else if (c == "http://www.youtube.com") {
            webView.loadUrl(c)
        } else if (d == "http://www.daum.net") {
            webView.loadUrl(d)
        }

    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

}