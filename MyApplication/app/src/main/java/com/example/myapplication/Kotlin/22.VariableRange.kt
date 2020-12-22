package com.example.myapplication.Kotlin

/*
<변수의 접근 범위>
1. 전역변수 : 어디에서든 접근할 수 있는 변수
    - 전역변수를 선언할 수 있는 공간은 한정적(제일 바깥 쪽에 선언해주면 된다)
2. 지역변수 : 해당 지역에서만 접근할 수 있는 변수
    - 지역변수는 해당 지역 안에서 선언해주면 된다.

변수의 접근 범위는 최소한으로 설정하는 것이 좋다.
모두 전역변수로 선언해버리면 어디서든 변경할 수 있기 때문에 위험하다.
 */
var number100:Int = 10 // 전역변수(어디서든 접근가능하다)

fun main(array: Array<String>) {
    println(number100)
    //println(name)  --> 클래스의 프로퍼티는 바깥에서 접근할 수 없다(1)
    var test=Test("김형진") // --> 클래스의 프로퍼티는 다음과 같이 객체를 생성해야지 접근할 수 있다(3)
    println(number100)
    test.testFun() // --> testFun에서 number100에 값을 할당한다.
    test.name   // 인스턴스의 멤버 변수에 접근하는 것이다.
    println(number100) // 10이 나온다
}

class Test(var name : String){
    fun testFun(){
        var birth : String = "2000/03/01" // testFun의 지역변수
        name="홍길동" // 지역변수(클래스 내부에서만 접근하거나, 객체생성을 통해 접근할 수 있다)
        // 클래스의 프로퍼티는 클래스 내부 함수에서는 접근이 가능하다(2)
        number100 = 100 // 최상위에 선언된 변수는 어디서든 접근이 가능하다.
        fun testFun3(){
            var gender : String = "male" // testFun3이라는 지역에서 선언한 변수이기에 tesfFun이라는 상위 지역에서는 접근할 수 없다.
        }
    }
    fun testFun2(){
        name // 내부함수보다 상위인 클래스에서 선언한 변수이기 때문에 하위에서는 접근 가능
        //birth   --> testFun이라는 다른 지역에서 선언한 변수이기 때문에 다른 지역에서는 접근할 수 없다.
    }
}