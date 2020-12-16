package com.example.myapplication.Kotlin

// 01. Variable ->  변수

/*
변수는 상자라고 할 수 있다.
<변수를 선언하는 방법>
val/var 변수명(상자) = 값(넣고 싶은 것)
val : value(변하지 않는 값)
var : variable(변할 수 있는 값)
 */

var num = 10;
var hello = "Hello Kotlin";
var point = 3.4;

val fix = 20;

fun main(args:Array<String>){
    println(num);
    println(hello);
    println(point);

    println(fix);

    num = 100;
    hello = "GoodBye Kotlin";
    point = 10.11;
    // var로 선언한 변수는 변경이 가능하다.

    println(num);
    println(hello);
    println(point);
    println(fix);

    //fix = 500;
    /*
    위와 같이 적으면 val cannot be reassigned라는 오류가 발생한다.
    값을 재할당할 수 없다는 의미이다.
     */
}
// fun main은 프로그램이 작동하면 main 안에 적힌 부분들이 실행이 되는 것이다.