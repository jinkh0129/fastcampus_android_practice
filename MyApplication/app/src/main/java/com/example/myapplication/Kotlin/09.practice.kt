package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    val a : Int? = null
    val b : Int = 10
    val c : Int = 100

    if (a == null){ // 조건의 결과값이 true/false라면 무슨 조건이라든 상관없다.
        println("a is NULL.")
    } else {
        println("a is Not NULL.")
    }

    if(b+c==110){
        println("b plus c is 110")
    } else {
        println("b plus c is not 110")
    }

    // 엘비스 연산자(해당 변수가 null인지 아닌지에 따라 다른 값을 출력하도록 제어)
    val number : Int? = null
    val number2 = number ?: 10 // number2에 number값이 들어갈텐데 number가 null이 아니라면 number값을 넣고 null이라면 10을 넣는다.
    // 코틀린은 nullsafety한 언어다.

    val num1 : Int = 10
    val num2 : Int = 20
    val max = if(num1>num2){
        num1
    } else if(num1 == num2){
        num2
    } else { // if를 통해 return을 할 때는 else를 되도록이면 적어주자
        100
    }
}