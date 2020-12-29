package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        Glide.with(this@LibraryActivity) // fragment없으면 context를 넣어주면 된다.
            .load("\"https://mimgnews.pstatic.net/image/109/2020/08/25/0004262115_003_20200825173615592.jpg?type=w540\"")
            .centerCrop()
            .into(glide)
        // Context를 넣어주면 Glide가 만들어지고 load를 하면 이미지를 당겨오고 glide라는 id를 가진 이미지뷰에 집어넣는다는 의미
    }
}