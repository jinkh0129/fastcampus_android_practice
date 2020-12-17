package com.example.myapplication.Kotlin

/*
<Function 함수>
 - 함수라는 것은 input을 넣어주면 output이 나오는 것을 의미한다.

<함수를 선언하는 방법>
fun 함수명(변수명 : 타입, 변수명 : 타입, ...) : 반환형 {
    함수의 내용...
    return 반환값
}

<함수를 사용하는 방법>
main함수 안에서 호출을 해줘야 한다.
 */

// 일반 함수 만들기
fun plus(first:Int, second:Int):Int{
    println("First : $first")
    println("Second : $second")
    val result : Int = first + second
    println("Result : $result")
    return result
}

// 디폴트 값을 갖는 함수 만들기
// default : 기본적으로 저장되어 있는 값
fun plusFive(first:Int,second:Int=5):Int{ // second 매개변수에 값을 할당하지 않으면 디폴트값을 쓰겠다는 의미
    val result : Int = first + second
    return result
}

// 반환값(return)이 없는 함수 만들기
fun printPlus(first:Int,second:Int):Unit{ // 반환값이 없는 함수를 선언할 때는 반환값의 자료형을 적는 곳에다가 Unit형을 적어줘야 한다.
    // Unit형은 사실 생략해도 괜찮다.
    val result : Int = first + second
    println(result)
}
fun printPlus2(first:Int,second:Int){
    val result:Int = first+second
    println(result)
}

// 간단하게 함수를 선언하는 방법
fun plusShort(first:Int,second:Int) = first + second // plus함수와 동일한 기능을 한다.

// 가변인자를 갖는 함수 선언하는 방법(vararg 키워드를 사용)
fun plusMany(vararg numbers : Int){
    for (number in numbers){
        println(number)
    }
}

fun main(array: Array<String>) { // main함수는 array라는 인자를 받는데 자료형은 Array<String>이라는 것을 알 수 있다. 또한 반환값의 타입이 없다.
    val result1 = plus(5,6) // 원칙적으로는 선언한 매개변수의 순서에 따라서 인자의 순서도 대응되서 들어간다.
    println("Result1 : $result1")
    val result2 = plus(first = 20, second = 30) // 명시적으로 매개변수를 선언한다면 인자의 순서는 상관없다.
    println("Result2 : $result2")
    val result3 = plus(second = 100, first = 10)
    println("Result3 : $result3")
    //디폴트값이 있는 함수 호출하기
    println()
    val result4 = plusFive(10,20)
    println("Result4 : $result4")
    val result5 = plusFive(20) // second에 디폴트값이 있기 때문에 값을 전달하지 않아도 함수가 실행이 된다.
    println("Result5 : $result5")
    // 반환값이 없는 함수 호출하기
    println()
    printPlus(10,20)
    // 간단한 함수 호출하기
    println()
    val result6 = plusShort(10,20)
    println("Result6 : $result6")

    println()
    plusMany(1,2,3,4)
    plusMany(100)
}

