package com.example.myapplication.Kotlin

// 14. 컬렉션(모음집)
/*
<Collection --> list, set, map>
 1. list
  - 중복을 허용한다.
 2. Set
  - 중복 허용X, 순서X
 3. Map
  - key와 value가 대응되어 저장되어야 한다.

컬렉션에도 값을 변경할 수 있는 컬렉션과 없는 컬렉션이 있다.
 */

fun main(array: Array<String>) {
    // List를 만드는 방법
    val numberList = listOf<Int>(1,2,3,3) // listOf를 사용하고 자료형은 <>에 입력한다. 배열 생성과 유사  / list는 중복을 허용한다.
    println(numberList)
    println(numberList.get(0)) // index값을 사용하여 값을 꺼낸다.
    println(numberList[0]) // 중괄호를 사용해서 접근할 수도 있다.
    
    // Set을 만드는 방법(집합) --> 중복X, 순서X
    val numberSet = setOf<Int>(1,2,3,3,3) // set(집합)의 특징은 중복을 허용하지 않는다. 즉, 동일한 값을 여러 번 입력해도 1개만 인식된다.
    println(numberSet)
    // println(numberSet.get(0)) --> set(집합)의 또 다른 특징으로는 순서가 없다는 값이다. 즉, index값을 사용해서 가져올 수 없다는 의미다.
    println()
    numberSet.forEach {
        println(it) // numberSet이 1개씩 출력된다.
    }
    
    // map을 만드는 방법
    // map은 key와 value 방식으로 관리한다. --> key와 value를 같이 할당해야 한다.
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2) // key와 value를 같이 적어주기 때문에 자료형 2개를 입력해야 한다.
    // key값은 one value는 1이라는 의미다.
    println()
    println(numberMap.get("one")) // map의 경우에는 key값을 사용해서 값을 불러온다.
    // "one"이라는 key에 대응되는 value값인 1이 출력된다.

// --> 지금까지의 컬렉션은 값을 변경할 수 '없는' 컬렉션이다.
// 이렇게 값을 변경할 수 없는 컬렉션을 immutable collection이라고 한다.

// Mutable Collection 변경 가능한 컬렉션은 다음과 같다 --> 그냥 앞에 mutable을 붙여주면 된다.
    val mnumberList = mutableListOf<Int>(1,2,3)
    mnumberList.add(3,4)
    println(mnumberList)

    val mNumberSet = mutableSetOf<Int>(1,2,3,3,3,3,4,4,4,4)
    mNumberSet.add(10) // set은 인덱스를 적어줄 필요가 없다. 순서가 없으니까.
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String,Int>("One" to 1)
    mNumberMap.put("Two",2) // map은 어떤 값을 넣어줄 때 add가 아니라 put을 사용한다.
    println(mNumberMap)

    // list와 set은 대괄호[]로 출력되는데, map은 중괄호{}로 출력된다.
}