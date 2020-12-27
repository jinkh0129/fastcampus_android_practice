package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent.*

// intent와 intent2의 화면전환
class Intent01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        change_activity.setOnClickListener {
            // Activity를 전환하기 위한 방법(1)
//            val intent = Intent(this@Intent01, Intent02::class.java) // 요청을 만들기만 하고 아직 보내지는 않음
            // Intent01에서 Intent02로 이동하겠다는 의미
            // 주변정보(Context)를 넣어주라니까 this@Intent01을 넣어줬고, 이동할 activity를 적고, ::class.java를 적어줘야한다
            // <Intent에 값을 넣어주는 방법>
            // key,value방식이다. --> key와 value를 쌍으로 만들어 저장한다.
//            intent.putExtra("number01",1) // 이름을 넣어주는 것은 여러 intent에서 원하는 것을 골라서 보낼 수 있도록 하는 것이다
//            intent.putExtra("number02",2)
//            startActivity(intent) // 이거는 이제 받는 쪽(Intent02)에서 값을 꺼낼 수 있다.

            
            
            // Activity를 전환하기 위한 방법(2) --> apply를 사용
            val intent02 = Intent(this@Intent01,Intent02::class.java)
            // ** apply는
            intent02.apply {
                // this:Intent는 intent02를 이 블록 안에서는 this로 사용하겠다는 의미이다.
                this.putExtra("number01",1)
                this.putExtra("number02",2)
            }
            startActivityForResult(intent02,200)
            // "Intent01 Activity가 intent02를 Intent02 Activity에게 20이라는 이름으로 보내는 것이다."
            // Intent02에게 여러명이 요청을 보낼 수 있는데 자신을 알아볼 수 있는 이름을 입력해줘야한다.(requestCode)

            /*
            <암시적 인텐트> - 페이지 불러오기
            val intent03 = Intent(Intent.ACTION_VIEW,Uri.parse("http://m.naver.com"))  --> ACTION_VIEW는 그 뒤에 오는 것을 보여주라는 의미다. / 페이지를 열려면 Uri.parse("")이런 식으로 적어줘야 한다.
            startActivity(intent03)
            --> 인터넷을 켤 수 있는 앱(크롬, 엣지 등)이 여러개 있을텐데 하나를 지정하지 않고 가능한 앱에게 부탁
             */

        }

    }

    // Intent02에서 보낸 결괏값을 보내려면 onActivityResult를 오버라이드 해줘야한다.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Intent02에서 Activity.RESULT_OK가 resultCode이다.
        // data에는 Intent02의 resultIntent변수에 있는 값이다.
        if(requestCode == 200){ // 우리가 요청한 것이 맞으면(requestCode=200)
            Log.d("number",""+requestCode) //위에서 200으로 정했다.
            Log.d("number",""+resultCode)
            val result = data?.getIntExtra("result",0)
            Log.d("number",""+result)
        }


        super.onActivityResult(requestCode, resultCode, data)

    }
}