package com.example.bottomnav_fragment_link

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class LifeCycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.d("LifeCycle","onCreate() is called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle","onStart() is called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle","onResume() is called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle","onPause() is called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle","onStop() is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle","onDestroy() is called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle","onRestart() is called")
    }
}