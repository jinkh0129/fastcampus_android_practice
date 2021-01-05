package com.example.myapplication2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first_manifest_parent.*

class FirstActivity_manifestParent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_manifest_parent)

        goSecond.setOnClickListener {
            val intent = Intent(this@FirstActivity_manifestParent,SecondActivity_manifestParent::class.java)
            startActivityForResult(intent,200)
        }
        goThird.setOnClickListener {
            val intent = Intent(this@FirstActivity_manifestParent,ThirdActivity_manifestParent::class.java)
            startActivityForResult(intent,300)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
            when(requestCode){
                200->{
                    Toast.makeText(this,"두번째화면에서 돌아온 메인화면입니다.",Toast.LENGTH_LONG).show()
                }
                300->{
                    Toast.makeText(this,"세번째화면에서 돌아온 메인화면입니다.",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
