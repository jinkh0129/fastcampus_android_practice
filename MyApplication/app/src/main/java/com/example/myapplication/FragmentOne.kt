package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

// 여기에 Fragment를 만드는 것이다.

class FragmentOne : Fragment(){ // 상속이니까 () 열어줘야한다
    // 직접 리스너를 구현하는 방법
    interface OnDataPassListener {
        fun onDataPass(data : String?)
    }
    lateinit var dataPassListener : OnDataPassListener

    override fun onAttach(context: Context) {
        Log.d("Life_cycle","F onAttach")
        super.onAttach(context)
        dataPassListener = context as OnDataPassListener // 형변환을 해준다.(casting)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Life_cycle","F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( // 뷰를 그리는 역할이다.
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // 리턴타입이 view니까 view를 리턴해줘야한다.
        Log.d("Life_cycle","F onCreateView")
        // Fragment가 인터페이스를 처음으로 그릴 때 onCreateView라이프사이클이 호출된다. 그래서 이 안에서 뷰를 그려줘야 한다.
        // cf) Activity의 경우 setContentView가 있는 onCreate라이프사이클이 호출된다.

        // inflater --> 뷰를 그려주는 역할
        // container --> 부모뷰(이 파일을 부른 xml파일에서 여기서 그린 뷰를 fragment뷰의 부모의 자식뷰로 들러붙도록 해준다. 결국 들러붙을 곳을 의미한다.)
        return inflater.inflate(R.layout.fragment_one,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life_cycle","F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        // Activity는 onCreate에서 작업을 주로하고, Fragment는 onViewCreated에서 주로 작업을 한다.
        pass.setOnClickListener {
            dataPassListener.onDataPass("Good Bye") // 리스너를 장착함
        }
        // 보내는 역할 받는 것은 Activity에서
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life_cycle","F onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        val data = arguments?.getString("hello")
        Log.d("data", data.toString())
    }

    override fun onStart() {
        Log.d("Life_cycle","F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Life_cycle","F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Life_cycle","F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Life_cycle","F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Life_cycle","F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("Life_cycle","F onDetach")
        super.onDetach()
    }
}