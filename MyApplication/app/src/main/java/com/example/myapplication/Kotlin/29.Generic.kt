package com.example.myapplication.Kotlin

// 29. Generic(제너릭)
/*
<제너릭>
1. 목적
    : 다양한 타입의 객체들을 다루는 메서드(함수)나 컬렉션, 클래스에서 컴파일 시에 타입을 체크해주는 기능이다.
    : 타입을 체크하는 기능이다.
2. 제너릭은 만들기 어렵고, 실제로 만들 일이 거의 없으니 사용하는 방법만 숙지하면 된다.
 */
fun main(args :Array<String>) {
    // 제너릭을 사용하지 않은 경우 --> 형변환을 해줘야 한다.
    val list1 = listOf(1,2,3,"가")
    val b : String = list1[2].toString() // 형변환(타입 변환)

    // 제너릭을 사용하는 경우 --> "타입이 안전하다"
    val list2 = listOf<String>("a","b","c")
    val c : String = list2[2] // String이라는 것을 보장받는다. 이유는 리스트를 선언할 때 타입을 정해줬기 때문에.

    // 강한 타입을 체크할 수 있다.
    val list3 = listOf(1,2,3,4,"가","나",3.0) // 아무 타입의 인자가 들어올 수 있다는 것은 타입을 체크할 수 없다는 것이다.
    val list4 = listOf<Int>(1,2,3) // 지정해준 타입 이외의 인자를 넣으면 오류가 난다. --> 강한 타입 체크
    
    // 제너릭을 사용하지 않은 경우
    val list5 = listOf(1,2,3,"가") // 이때 list5의 타입은? --> Any
    // 부모클래스 : Any
    // 자식클래스 : Int, String, Double ...
}