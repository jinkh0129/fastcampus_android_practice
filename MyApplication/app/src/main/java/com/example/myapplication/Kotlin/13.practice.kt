package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    val array = arrayOf<Int>(1,2,3)
    // get, set
    // index는 0부터 시작
    val number = array.get(0)
    println(number)
    // val number1 = array.get(100) // 없는 index를 사용하면 어떻게 될까? --> ArrayIndexOutOfBoundsException 라는 오류가 발생!
    // index에 주의해야 한다.
    println(number1)
    array.set(0,100)
    val number2 = array.get(0)
    println(number2)

    //array.set(100,100) // --> ArrayIndexOutOfBoundsException 라는 오류가 발생!

    // array의 Bounds를 파악하는 방법
    // --> 처음 만들 때 결정이 된다.
    // array는 처음 만들 때의 사이즈를 추후에 변경하기 어렵다.

    // Array를 만드는 방법(3)
    val a1 = intArrayOf(1,2,3) // Int만 넣을 수 있는 배열이다 <Int>를 사용할 필요 없다.
    val a2 = charArrayOf('a','b','c') // 문자 하나만 넣을 수 있는 charArray도 생성가능
    // char형은 작은따옴표를 사용해야 한다.
    val a3 = doubleArrayOf(1.2, 100.34)
    val a4 = booleanArrayOf(true,false,true)

    // Array를 만드는 방법(4) --> 람다를 활용하는 방법
    var a5 = Array(10,{0}) // size를 먼저 지정, {}를 사용해서 요소값을 넣어준다. {0}은 사이즈 10 전체를 0으로 채운다는 의미
    val a6 = Array(5, {1;2;3;4;5}) // 람다 안에서는 쉼표가 아니라 세미콜론으로 구분한다.







}