package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("Life_cycle","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Life_cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life_cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life_cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life_cycle","onStop")
    }
    // pause와 stop의 구분은 애매하다. 그래서 그냥 하나의 단계에 몰아서 적어도 된다.

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life_cycle","onDestroy")
    }
}