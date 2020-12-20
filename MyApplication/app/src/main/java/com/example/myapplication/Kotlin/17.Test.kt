package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    //first()
    println(second(80))
    //rintln(third(89))
    //gugudan()
}

/*
1번 문제
list를 2개 만든다
첫번째 List에는 1부터 9까지 값을 넣는다.(반복문 사용) --> 초기에 넣는 것이 아니라 반복문을 사용하며 하나하나 넣어주는 것이다.
두번째 List에는 첫번째 List의 값을 하나씩 확인한 후 짝수면 True, 홀수면 False를 넣어준다.
 */

/*
2번 문제
학점을 구하자
80-90 - A
70-79 - B
60-69 - C
나머지 F
 */

/*
3번 문제
전달 받은 숫자의 각 자리 수의 합을 구하자
조건 : 전달 받은 숫자는 무조건 두자리 숫자이다.
 */

/*
4번 문제
구구단을 출력하자
 */
fun first(){
    
}


fun second(score:Int):Unit{
    when(score){
        in 80..90 -> println("A")
        in 70..80 -> println("B")
        in 60..70 -> println("C")
        else -> println("F")
    }
}