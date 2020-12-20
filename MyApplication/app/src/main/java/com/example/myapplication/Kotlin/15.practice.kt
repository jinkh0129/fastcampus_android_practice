package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    val a = mutableListOf<Int>(1,2,3)
    a.add(4) // index를 설정해주지 않으면 그냥 제일 뒤에 추가한다.
    println(a)
    a.add(0,100) // index와 value값을 같이 넣어주면 추가할 위치까지 같이 지정을 해주는 것이다.
    println(a)
    a.set(0,200) // set 키워드를 사용하면 추가가 아니라 변경(덮어쓰기)이다.
    a.removeAt(1) // index값을 입력하면 해당 인덱스 위치에 있는 값을 제거한다.

    val b = mutableSetOf<Int>(1,2,3,4)
    b.add(2) // 집합에서는 중복이 허용되지 않기 때문에 이미 있는 2를 넣으면 소용이 없다.
    // 그리고 애초에 순서가 존재하지 않기 때문에 index를 넣지 않는다.
    println(b)
    b.remove(2) // 집합은 인덱스가 없으니까 removeAt이 아니라 그냥 remove다
    println(b)
    b.remove(100) // 만약 집합 내에 없는 값을 삭제하려고 해도 에러는 발생하지 않는다.
    println(b)

    val c = mutableMapOf<String,Int>("one" to 1)
    println()
    c.put("two",2)
    println(c)
    c.replace("two",3)
    println(c)
    println(c.keys) // map에 있는 key만 출력할 때
    println(c.values) // map에 있는 value만 출력할 때
    c.clear() // map안에 있는 모든 것을 비운다.
    println(c)
}