package com.example.myapplication.Kotlin

// 02.자료형
/*
정수형 : Long > Int > Short > Byte
실수형 : Double > Float
문자(1글자) : Char
문자열(1글자 이상) : String
논리형 : Boolean(true/false)

<변수를 선언하는 방법(2)>
var/val 변수 : 자료형 = 값
 */
var number = 10; // 자료형을 선언하지 않아도 코틀린에서 추론을 한다.
// 값을 할당하지 않아도 자료형을 명시해서 선언해주면 변수를 정의할 수 있다 --> 이 경우에는 var만 가능하다.(val는 변경이 안되니까)

var number1 : Int = 20;
var hello1 : String = "Hello";
var point1 : Double = 3.4;
//--> 코틀린이 추론을 하니까 자료형을 적어주지 않아도 괜찮지만, 명시해 주면 더욱 확실하게 할 수 있으니까 명시해주는 습관을 갖도록 하자.

/*
value or variable
(1) 변하지 않는 값 --> val(value)
(2) 변수가 변할지 변하지 않을지 잘 모를 경우 --> val(value)로 선언하고 프로그래밍하다가 오류가 나면 그 때 바꿔도 괜찮다.
*/


fun main(array: Array<String>) {
    number = 20 // 여기서는 Int형으로 추론했으니까
    //number = 20.5 // 여기서 Float형을 집어넣으면 오류가 난다.
}
