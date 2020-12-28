package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {
    lateinit var lateCar : Car // lateinit은 primitive type에는 사용할 수 없다.
    class Car(var number : Int){

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number : Int = 10
        // val number1 : Int = null --> Error발생
        val number1 : Int? = null // 변수에 null을 넣어주려면 세이프콜(?)을 사용

        // var number5 : Int = number1 + 10 ---> number1의 type이 Int?이기 때문에 Int일수도 null일수도 있는 것이다. 그래서 Error가 난다.
        //          --> 그렇지만 개발자가 number1이 null이 아님을 100%확신할 때 number1!!와 같이 !!를 적어주면 Error가 나지 않는다.
        
        // number1이 null이 아니라면 number와 더한 값을 number3에 할당하는 과정
        val number3 = number1?.plus(number) // number1가 null이니까 number3도 null이 된다.
        //Log.d("number","number3 : "+number3)

        // **삼항 연산자** --> 엘비스연산자(?:)
        //      --> nullsafety하게 해주는 역할
        val number4 = number1 ?: 10 // number1이 null이 아니면 number1가 number4로 들어가지만 null이라면 10이 들어간다.
        //Log.d("number","number4 : "+number4)
        //Log.d("number","late car : "+lateCar.number) // ---> lateinit으로 초기값 세팅을 하지않으면 ERROR가 발생한다.
        lateCar = Car(10) // lateinit으로 미뤘던 세팅을 해줌
        Log.d("number","late car : "+lateCar.number) // ---> 세팅 후에는 ERROR가 발생하지 않는다.
    }

    fun plus(a:Int, b:Int?):Int{
        if(b!=null) return a+b
        else return a
    }

    fun plus2(a:Int, b:Int?):Int?{ // null이 반환될 수 있으니 반환자료형도 ?를 붙여준다.
        return b?.plus(a)
    }
}