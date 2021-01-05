package com.example.customapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_success_login.*
import kotlinx.android.synthetic.main.activity_u_r_l.*

class SuccessLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_login)

        var result = intent.getStringExtra("ID")
        Toast.makeText(this, "${result}님 안녕하십니까", Toast.LENGTH_LONG).show()

        move_btn.setOnClickListener {
            val intent = Intent(this@SuccessLoginActivity,MainActivity::class.java)
            startActivity(intent)
        }

        move_to_youtube.setOnClickListener {
            val intent = Intent(this@SuccessLoginActivity,URLActivity::class.java)
            startActivity(intent)
        }

    }
}