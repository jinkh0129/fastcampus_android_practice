package com.example.myapplication.Kotlin

var a = 1 + 2 + 3 + 4 + 5; // 표현식을 사용하여 변수를 선언할 수도 있음.
var b = "1";
var c = b.toInt(); // 명시적 형 변환. 결국 c에는 정수 1이 할당된다.
var d = b.toFloat(); // 명시적 형 변환. d에는 1.0이 할당된다.

var e = "John";
var f = "My name is $e. Nice to meet you."

/*
<null>
 - null은 '존재하지 않는 것'을 의미한다. --> 있다가 사라진 것이 아니라 애초에 없는 것이다.

 */

//var abc : Int = null; // 그냥 null을 할당하면 오류가 난다. 그래서 자료형에 null을 받을 수 있도록 해줘야 한다. 물음표(?)를 사용해야 한다.
var abc : Int? = null; // --> 자료형 뒤에 물음표(?)를 붙여주면 null을 가질 수 있는 자료형이 된다.
var abc2 : Double? = null; // 실제로 어떤 값이 들어가는 것이 아니다. "null"이라는 문자열 절대 아니다.

var g = a+3;

fun main(array: Array<String>) {
    println(a);
    println(b);
    println(c);
    println(d);
    println(e);
    println(f);
    println(abc);
    println(abc2);
    println(g);
}
