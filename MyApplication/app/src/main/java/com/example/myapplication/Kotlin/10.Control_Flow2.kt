package com.example.myapplication.Kotlin

// 10. 제어흐름
/*
<when구문>

 */

fun main(array: Array<String>) {
    val value : Int = 3
    when(value){  // if의 조건은 true/false 둘 중 하나의 결과가 나와야 하는데, when은 반드시 true나 false일 필요가 없다.
        1 -> println("value is 1.") // 중괄호 안에 내용이 짧다면 이렇게 축약한 형태로 적을 수도 있다.
        2 -> {
            println("value is 2.")
        }
        3 -> {
            println("value is 3.")
        }
        else -> {
            println("I don't know what the fuck the value is.")
        }
    }

    if (value==1){
        println("value is 1.")
    } else if(value==2){
        println("value is 2.")
    } else if(value==3){
        println("value is 3.")
    } else {
        println("I don't know what the fuck the value is.")
    }
    // --> 위의 when구문을 if구문으로 바꾸면 다음과 같다. 보통 when으로 적은 것이 가독성이 좋다.

    // when도 흐름을 제어하는 기능뿐만 아니라 리턴하는 기능도 있다.
    val value2 = when(value){
        1->10
        2->20
        3->30
        else->100
    }
    println(value2)
}