package com.example.myapplication.Kotlin

// 12. 배열
/*
<배열이 필요한 이유>
  - 그룹이 필요할 때
 */

fun main(array: Array<String>) {
    val one: Int = 1
    val two: Int = 2
    val three: Int = 3
    val four: Int = 4
    val five: Int = 5

    // 배열을 생성하는 방법(1)
    val number: Int = 1 // 변수는 '선언'한다고 표현한다.
    var group1 = arrayOf<Int>(1,2,3,4,5) // 배열을 생성할 때는 arrayOf키워드를 사용하고 자료형을 정해줄 때는 <>에 자료형을 적어준다.

    println(group1 is Array)

    // 배열을 생성하는 방법(2)
    var number1 = 10 // type을 생략했을 때 자료형을 추론한다.
    val group2 = arrayOf(1,2,3.5,"Hello") // 배열의 경우, 자료형을 지정하지 않을 경우 그 배열에는 어떤 타입의 값을 넣어줄 수 있다.


    /*
    <index란>
    [1,2,3,4,5]
    인덱스는 0부터 시작해서 순서를 의미한다.
     */
    // 배열의 값을 꺼내는 방법(1)
    val test1 = group1.get(0) // index.int를 적어줘야 한다.
    println(test1)
    val test2 = group1.get(4)
    println(test2)

    // 배열의 값을 꺼내는 방법(2)
    val test3 = group1[0]
    println(test3)

    // 배열의 값을 바꾸는 방법(1)
    group1.set(0,100) // set(인덱스, 바꿀 값)
    println(group1[0])

    // 배열의 값을 바꾸는 방법(2)
    group1[0]=200
}