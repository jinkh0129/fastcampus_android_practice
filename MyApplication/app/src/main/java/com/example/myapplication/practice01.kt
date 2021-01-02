package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_practice01.*

class practice01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice01)

        result_button.setOnClickListener {
            val intent = Intent(this@practice01,practice02::class.java)
            intent.apply {
                this.putExtra("name","khjin")
            }
            startActivity(intent)
        }


    }
}