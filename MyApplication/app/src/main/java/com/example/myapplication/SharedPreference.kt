package com.example.myapplication

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)


        // SharedPreference


        /*
        Mode
        - MODE_PRIVATE : 생성한 어플리케이션에서만 사용 가능
        - MODE_WORLD_READABLE : 다른 어플리케이션에서 사용 가능 -> 읽을 수만 있음
        - MODE_WORLD_WRITABLE : 다른 어플리케이션에서 사용 가능 -> 기록도 가능함
            --> 보통 어플을 1개 만들기 때문에 PRIVATE을 사용한다.
            --> 여러개의 어플을 만들어 서로 상호작용을 하게 하려면 WORLD를 해야 한다.
        - MODE_MULTI_PROCESS : 이미 호출되어 사용 중인지 체크
        - MODE_APPEND : 기존 preference에 신규로 추가    
         */

        // 데이터를 SharedPreference에 넣어줘야함. --> 넣을 때는 에디터라는 것을 SharedPreference로부터 가져와서 데이터를 넣어주는 것이다.
        //val editor: SharedPreferences.Editor = sharedPreference.edit() // 에디터를 얻어옴(에디터는 넣어줄 때만 필요하다)
        // 데이터를 저장할 때는 Key_Value방식이다.
        //editor.putString("hello", "안녕하세요") // --> 아직 데이터를 저장한 것이 아니다. 커밋이라는 것을 해야지 데이터가 저장이 된다.
        //editor.commit() // 커밋까지 해야 입력한 데이터가 저장이 된다.
        // 어플을 한 번 Run을 해서 commit()으로 한 번 저장을 하면 어플을 다시 시작한다고 해서 값이 사라지고 다시 저장되는 것이 아니다.

        save_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences(
                "sp1",
                MODE_PRIVATE
            ) // name:String, mode:Int를 넣어주라고 한다, sharedpreference도 여러개를 만들 수 있기 때문에 구분을 위한 이름을 넣는 것이다.
            //--> SharedPreference 만드는 방법(이름으로 각각의 SharedPreference를 구분)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히세가세요")
            editor.commit()
        }

        load_btn.setOnClickListener {
            /* 저장한 값을 불러오는 방법 */
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            // 일단 저장할 때와 동일한 방법으로 SharedPreference를 가져온다.
            val value1 = sharedPreference.getString("hello", "데이터 없음1")
            val value2 = sharedPreference.getString("goodbye", "데이터 없음2")
            // 값을 꺼내올 때는 넣어줄 때 입력한 키값으로 바로 가져온다(에디터 필요없음)
            Log.d("key_value", "Value1 : " + value1)
            Log.d("key_value", "Value2 : " + value2)
        }


        /* 데이터를 삭제하는 법 */

        // 부분삭제
        delete_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences(
                "sp1",
                MODE_PRIVATE
            ) // name:String, mode:Int를 넣어주라고 한다, sharedpreference도 여러개를 만들 수 있기 때문에 구분을 위한 이름을 넣는 것이다.
            //--> SharedPreference 만드는 방법(이름으로 각각의 SharedPreference를 구분)
            val editor = sharedPreference.edit()
            editor.remove("hello") // 부분삭제(키값 사용)
            editor.commit() //에디터를 사용했으면 반드시 commit으로 종료
        }
        // 전체삭제














        
        deleteAll_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences(
                "sp1",
                MODE_PRIVATE
            ) // name:String, mode:Int를 넣어주라고 한다, sharedpreference도 여러개를 만들 수 있기 때문에 구분을 위한 이름을 넣는 것이다.
            //--> SharedPreference 만드는 방법(이름으로 각각의 SharedPreference를 구분)
            val editor = sharedPreference.edit()
            editor.clear() // 키값입력X 전부삭제
            editor.commit() 
        }


    }
}