package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_open_page.*

class OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_page)

        // EditText에 타이핑이 될 때마다 변화를 탐지하는 로직
        // --> 사용자의 텍스트를 감지해서 원하는 값을 입력했을 때 특정한 동작을 할 수 있다.
        address_edit_text.addTextChangedListener(object :TextWatcher{
            /*
            object 익명함수를 써야하는지 어떻게 알까?
            - addTextChangedListener()를 입력하면 괄호 안에 watcher : TextWatcher!라고 뜬다.
              이런 식으로 나오면 object를 넣으라는 의미다.
            - object를 적고 나서 익명함수가 가지고 있는 함수들을 override를 해주면 된다.
             */
            // object는 익명함수니까 바로 override를 해주면 된다.
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // start는 변하기 전 총 몇 글자,count는 변화된 글자 수,after는 변화 후 총 몇 글자
                Log.d("edit","beforeTextChanged : "+s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit","onTextChanged : "+s)
            }

            override fun afterTextChanged(s: Editable?) {
                if(s.toString() == "abc"){ // 입력한 값이 abc인 경우 로그를 출력한다.
                    Log.d("edit","text is : "+s)
                }
            }
        })

        
        // 클릭했을 때 홈페이지로 들어가게 하도록 하는 로직
        open.setOnClickListener { 
            val address = address_edit_text.text.toString()
            // EditView에 입력된 값을 가져올 때는 그냥 text를 사용해서 변수에 넣어주면 되는구나...
            // text는 Editable이라는 타입이다. 그런데 Uri.parse()안에는 String형을 넣어줘야 하기 때문에
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse(address))
            startActivity(intent)
        }


     }


}