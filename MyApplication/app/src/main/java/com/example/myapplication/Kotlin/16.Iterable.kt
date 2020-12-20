package com.example.myapplication.Kotlin

// 16. Iterable(반복문)
/*

 */
fun main(array: Array<String>) {
    val a = mutableListOf<Int>(1,2,3,4,5,6,7,8,9)

    // 반복하는 방법(1) --> for 구문
    for (item in a){
        if(item==5){
            println("item is ${item}")
        } else {
            println("item is not , ${item}")
        }
    }
    println()
    println("----------------------------")

    // 반복하는 방법(2) --> index값과 value값을 모두 알고 싶을 때
    for((index,item) in a.withIndex()){ // index와 item 둘 다 가질 수 있다.
        println("Index : $index, Value : $item")
        // 문자열 + 아무거나 = 문자열
    }
    println("----------------------------")

    // 반복하는 방법(3) --> index없이 값만 반환
    a.forEach {
        // a의 하나하나가 어디에 담겨오는지 알 수 없다. 그런데 위를 보면 it에 담겨온다는 것을 알 수 있다.
        println(it)
    }
    println("----------------------------")

    // 반복하는 방법(4)
    a.forEach { item ->
        // it말고 다른 이름으로 값을 받고 싶을 때는 (이름) -> 형식으로 쓴다.
        println(item)
    }
    println("----------------------------")

    // 반복하는 방법(5) --> index값과 value값을 모두 알고 싶을 때
    a.forEachIndexed { index, item ->
        println("Index : $index, Value : $item")
    }
    println("----------------------------")

    // 반복하는 방법(6)
    for (i in 0 until a.size){ //index만을 순회하는 for문이다. a.size는 여기서 9이고 0 until 9는 0부터 8까지를 포함한다. 즉 제일 마지막은 포함하지 않는다.
        // until은 마지막을 포함하지 않는다.
        // i는 index값을 받는다. !!!!value값을 받는 것이 아니다.
        println(a.size)
        println(a.get(i))
        // i는 value값이 아니라 인덱스값이니 get()을 사용해서 value를 얻을 수 있다.
    }
    println("----------------------------")
    // 반복하는 방법(7)
    for (i in 0 until a.size step(2)){ // step은 건너뛰는 크기를 말한다. step(2)는 2씩 건너뛴다는 의미다.
        println(a.get(i))
    }
    println("----------------------------")
    // 반복하는 방법(8)
    for (i in a.size -1 downTo (0)){ // 8부터 0까지 반복
        // 지금까지는 낮은 인덱스부터 높은 인덱스로 올라갔는데
        // 이거는 위에서 아래로 내려가는 것이다.
        println(a.get(i))
        
    }
    println("----------------------------")
    // 반복하는 방법(9)
     for(i in a.size -1 downTo (0) step(2)){ // 2칸씩 뛰어서 내려오겠다는 의미
         println(a.get(i))
     }
    println("----------------------------")
    // 반복하는 방법(10)
    for (i in 0..10){ // 범위연산자(..)는 마지막 순자를 포함한다.
        println(i)
    }
    println("----------------------------")

    //  반복하는 방법(11)
    var b : Int = 0
    var c : Int = 4
    while(b<c){
        // 조건식이 true인 동안 계속 실행되기 때문에 수행문에서 꼭 빠져나가는 조건이 있어야 한다.
        b++ // while문을 정지시키기 위한 코드
        println("b")
    }
    println("----------------------------")

    // 반복하는 방법(12)
    do{
        println("Hello")
    } while(b<c)
    // --> while문은 조건문이 false면 while의 수행문이 실행조차 되지 않지만
    // do~while은 조건의 true/false와 상관없이 do구문이 무조건 1번은 실행된다.
}