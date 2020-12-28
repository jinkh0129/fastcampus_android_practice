package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)


        // string.xml에서의 값을 가져오는 방법(1)
        val ment = resources.getString(R.string.hello)
        Log.d("ment","ment : "+ment)

        // string.xml에서의 값을 가져오는 방법(2)
        val ment2 = getString(R.string.hello)
        Log.d("ment","ment2 : "+ment)

        // colors.xml에서의 색을 가져오는 방법(1)
        val color = resources.getColor(R.color.textview_color)
        Log.d("ment","color"+color)

        // colors.xml에서의 색을 가져오는 방법(2)
        val color2 = getColor(R.color.textview_color)
        Log.d("ment","color"+color)

        // button에 백그라운드컬러 변경해주는 방법
        button.setBackgroundColor(getColor(R.color.textview_color))
        
    }

}