package com.example.bottomnav_fragment_link

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.webview.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var HomeFragment: homeFragment
    private lateinit var GameFragment: gameFragment
    private lateinit var ChatFragment: chatFragment
    private lateinit var CameraFragment: cameraFragment
    private lateinit var ProfileFragment: profileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navi.setOnNavigationItemSelectedListener(this)

        HomeFragment = homeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragment_frame, HomeFragment).commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                HomeFragment = homeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, HomeFragment)
                    .commit()
            }
            R.id.nav_camera -> {
                CameraFragment = cameraFragment.newInstance()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_frame, CameraFragment).commit()
            }
            R.id.nav_profile -> {
                ProfileFragment = profileFragment.newInstance()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_frame, ProfileFragment).commit()
            }
            R.id.nav_chat -> {
                ChatFragment = chatFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, ChatFragment)
                    .commit()
            }
            R.id.nav_game -> {
                GameFragment = gameFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, GameFragment)
                    .commit()
            }
        }
        return true
    }
}