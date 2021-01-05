package com.example.customapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_btn.setOnClickListener {
            val intent = Intent(this@LoginActivity, SuccessLoginActivity::class.java)
            intent.putExtra("ID",id_txt.text.toString())
            startActivity(intent)
        }

    }
}