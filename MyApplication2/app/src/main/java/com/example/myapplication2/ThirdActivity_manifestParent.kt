package com.example.myapplication2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third_manifest_parent.*

class ThirdActivity_manifestParent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_manifest_parent)

        back_btn2.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}