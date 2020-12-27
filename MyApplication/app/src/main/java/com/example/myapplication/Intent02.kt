package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent02.*

class Intent02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent02)



        result.setOnClickListener{
            // Intent01에서 putExtra를 통해 보낸 값을 받으려면 getExtra를 쓴다.
            val number01 = intent.getIntExtra("number01",0) // 만약 넘어오는 값이 없다면 디폴트값을 넣어준다.
            val number02 = intent.getIntExtra("number02",0)

            Log.d("number",""+number01)
            Log.d("number",""+number02)

            val result = number01 + number02

            //결과(변수 result)를 이제 Intent01로 넘겨주는 방법은 다음과 같다.
            val resultIntent = Intent()
            resultIntent.putExtra("result",result)
            setResult(Activity.RESULT_OK,resultIntent) // resultIntent를 setResult에 할당해주는 것이다.
            //RESULT_OK는 -1이고, 잘 받았고 결괏값을 잘 전달하겠다는 의미다.
            //RESULT_CANCLED는 0이다.
            this.finish() // -> Activity종료(여기서는 Intent02를 종료시키고 Intent01을 불러오는 것)
        }
    }
}