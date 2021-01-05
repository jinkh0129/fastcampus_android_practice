package com.example.myapplication2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_design.*
/*
<Fragment를 사용하기 위한 준비>
준비물 : Activity 1개(kt파일, xml파일), kt파일, xml파일
방법
1. Activity의 xml파일에 container를 만들어준다(보통 LinearLayout을 사용).
2. 컨테이너에 넣을 xml파일을 만든다.
3. kt파일에서 fun onCreateView에 inflater를 사용해서 해당 xml파일을 가져온다.
4. Activity의 kt파일에서 kt파일(Fragment클래스)을 가져온다.
 */
class design : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design)

        // (1) Activity의 xml에 <fragment>를 사용한 경우(name을 통해 지정해줘야함) ---> 정적인 사용(onCreate되자마자 붙는다)
        //val fragmentOne = practice() // 이렇게 kt파일을 가져오기만 해도 Fragment가 <fragment>부분에 붙는다.

        // (2) <fragment>를 사용하지않고 <LinearLayout>의 container를 사용하는 방법 ---> 동적인 사용(사용자의 클릭 등에 의해 보여지는 타이밍 조절 가능)
        val fragmentOne = practice() // <fragment>를 쓰지 않는다면 이렇게 kt파일을 가져오는 것으로는 화면에 보여지지 않는다.

        selec_1.setOnClickListener {
            val fragmentManager = supportFragmentManager // container에 붙이려면 supportFragmentManager를 사용해야한다.
            val fragmentTransaction = fragmentManager.beginTransaction() // beginTransaction()으로 시작을 알려야한다.
            fragmentTransaction.replace(R.id.container,fragmentOne) // 붙이고 싶은 부분(container)에 프래그먼트(fragmentOne)을 붙여준다.
            fragmentTransaction.commit() // commit()으로 끝을 알려야한다.
        }
        selec_2.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }

    }
}