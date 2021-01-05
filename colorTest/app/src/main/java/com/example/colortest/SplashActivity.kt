package com.example.colortest

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.linearLayout

class SplashActivity :AppCompatActivity() {
    val TAG: String = "로그"

    // view가 생성되었을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        var slideDownAnimation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.slide_down)
//        var slideUpAnimation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.slide_up)
//        splash_title.startAnimation(slideDownAnimation)


        //slideDown(splash_title, 4000)
        slideUp(splash_title, 4000)
    }
    
    // 위로 올리기
    fun slideUp(view: View,time : Int){
        //
        val animation = TranslateAnimation(0f,0f,300f,-300f)
        animation.duration = time.toLong()
        animation.fillAfter = true
        view.startAnimation(animation)
    }
    // 아래로 내리기
    fun slideDown(view: View,time : Int){
        //
        val animation = TranslateAnimation(0f,0f,0f,300f)
        animation.duration = time.toLong()
        animation.fillAfter = true
        view.startAnimation(animation)
    }
}