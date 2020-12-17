package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    // 산술연산자
    var a = 1 + 1;
    var b = 321 - 6;
    var c = 4 * 2;
    var d = 20 / 3;
    var e = 20 % 3;

    println(a);
    println(b);
    println(c);
    println(d);
    println(e);
    
    // 대입연산자
    val f = 5;

    // 복합대입연산자
    a += 10;
    b -= 10;
    c *= 3;
    d /= 4;
    e %= 2;

    println(a);
    println(b);
    println(c);
    println(d);
    println(e);

    // 증감연산자
    a++
    b--
    println()
    println(a)
    println(b)

    // 비교연산자(boolean형으로 나온다)
    val g = a > b // false
    var h = a == b // a와 b가 같냐는 의미
    var i = !h// !(not)연산자 : 정수와 실수는 뒤집을 수 없으므로 Boolean값에 대해서만 연산을 한다.
    var l = i != h // i와 h의 비교를 통한 값을 l에 저장
    println()
    println(g)
    println(h)
    println(i)
    println(l)

    // 논리연산자
    val j = h && i // 둘다 true여야 true
    val k = h || i // 한쪽만 true여도 true
    println(j)
    println(k)



}