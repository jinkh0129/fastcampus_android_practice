package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener { // 인터페이스를 사용하면 반드시 함수를 구현해줘야한다.
    override fun onDataPass(data: String?) {
        Log.d("pass",""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("Life_cycle","onCreate")
        val fragmentOne : FragmentOne = FragmentOne()//---------------------------------------------------(3)
        
        // Fragment에 데이터를 넣어주는 방법
        //  cf) Intent는 putExtra를 사용해서 데이터를 넣어주었다
        // Bundle을 만들어서 Fragment에 끼워넣어줘야한다.
        val bundle : Bundle = Bundle()
        bundle.putString("hello","hello") //--> key/value방식
        fragmentOne.arguments = bundle // fragment에 Bundle을 할당하는 방법


        button.setOnClickListener{
            // Fragment를 동적으로 작동하는 방법
            //val fragmentOne : FragmentOne = FragmentOne() //type은 Activity형 //------------------------(1)
            // fragment를 동적으로 만들기 위해서는 fragmentManager를 사용해야 한다.
            val fragmentManager : FragmentManager = supportFragmentManager
            // 그리고 Transaction을 만들어줘야 한다.
            // Transaction은 작업의 단위이다. 시작과 끝이 있다.
            val fragmentTransaction = fragmentManager.beginTransaction() // beginTransaction이 호출되는 순간 이제 Transaction을 시작하겠다는 의미
            
            // Fragment replace/add 하는 방법
            fragmentTransaction.replace(R.id.container, fragmentOne)
            //  --> Containers와 우리가 만든 fragment를 바꿔주겠다는 의미
            fragmentTransaction.commit() // 끝을 의미
            /*
            끝을 내는 방법
            1. commit() -----> 시간 될 때 해(더 안정적)
            2. commitNow() --> 지금 당장
             */
        }
        button2.setOnClickListener {
            //val fragmentOne : FragmentOne = FragmentOne()//----------------------------------------------(2)
            // (1)과 (2)는 서로 다르다(지역변수/전역변수)
            // 둘다 같은 값을 사용하려면 상위층에 변수를 선언해주면 된다 --> (3)처럼
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            
            // Fragment remove/detach 하는 방법
            //fragmentTransaction.detach(fragmentOne) // detach를 하려면 attach(relace)했던 거를 입력해야한다.
            //      --> 한 번 '사라져'를 눌러서 detach하면 '나와라'를 눌러도 다시 바뀌지 않는다.
            fragmentTransaction.remove(fragmentOne)
            //      --> remove하고 다시 '나와라'를 눌르면 바뀐다.
            fragmentTransaction.commit()
        }
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