package com.example.myapplication.Kotlin

// 08. 제어 흐름
//main메소드가 실행되면 순차적으로 실행이 되는데 그 흐름을 변경하는 것을 제어 흐름이라고 한다.

fun main(array:Array<String>) {
    val a : Int = 5
    val b : Int = 10
    // if...else를 사용하는 방법(1)
    if(a>b){
        println("a is bigger than b.")
    } else {
        println("a is smaller than b.")
    }
    println("조건과 상관없는 문장")

    // if...else를 사용하는 방법(2)  --> if가 있다고 해서 무조건 else가 있어야 하는 것은 아니다.
    if(a>b){
        println("a is bigger than b.")
    }
    // 중괄호({}) 안에 내용이 1줄이면 중괄호를 생략해서 작성할 수도 있다.

    // if...else/elseif를 사용하는 방법 --> else if는 개수가 많아도 상관없다. 여기서도 else는 생략할 수 있다.
    if(a>b){
        println("a is bigger than b.")
    } else if(a<b) {
        println("a is not bigger than b.")
    } else {
        println("a is equal to b.")
    }
    
    // 값을 리턴하는 if 사용 방법  --> 값을 리턴한다는 것은 결과를 변수에 담는 것을 의미한다.
    // if가 값을 리턴하지 않는다면 변수에 할당할 수 없다. 리턴을 하는 경우에는 모든 경우의 수를 커버하는 조건을 만족해야한다. 그래야지 무조건 값을 리턴한다.
    val max = if(a>b){
        a // a=5
    } else {
        b // b=10
    }
    // val max = if(a>b) a else b 와 같이 축약가능하다.
    println()
    println(max)

}
