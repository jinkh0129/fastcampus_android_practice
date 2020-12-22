package com.example.myapplication.Kotlin

fun main() {
    val calculator1 = Calculator1()
    println(calculator1.plus(4,5))
    println(calculator1.minus(4,5))
    println(calculator1.multiply(4,5))
    println(calculator1.divide(4,5))

    println("--------------------------------")
    val calculator2 = Caculator2()
    println(calculator2.plus(1,2,3,4,5))
    println(calculator2.minus(10,2,3,4))
    println(calculator2.multiply(1,2,3,4,5))
    println(calculator2.divide(10,2,5,1))

    println("--------------------------------")
    val caculator3 = Calculator3(3)
    caculator3.plus(5).minus(3).mulitply(4)
    // caculator3.plus(5)가 반환될 때 클래스 자료형으로 반환이 되서 하나의 객체로 간주한다.
    // 그래서 그 다음에 다시 클래스의 멤버 메서드를 사용할 수 있다.
    // --> Chaining이라고 한다.(체이닝)
}

class Calculator1(){ // 가장 쉬운 방법(2개의 숫자만 연산 가능)
    fun plus(a:Int,b:Int):Int{
        return a+b
    }
    fun minus(a:Int,b:Int):Int{
        // 먼저 들어온 수에서 뒤에 들어온 수를 뺀다.
        return a-b
    }
    fun multiply(a:Int,b:Int):Int{
        return a*b
    }
    fun divide(a:Int,b:Int):Int{
        // 먼저 들어온 수에서 뒤에 들어온 수를 나눠준다.
        return a/b
    }
}

class Caculator2(){
    fun plus(vararg numbers:Int):Int{
        var result = 0
        numbers.forEach {
            result = result + it
        }
        return result
    }
    fun minus(vararg numbers:Int):Int{
        var result : Int = numbers[0]
        for(i in 0 until numbers.size){
            if(i!=0){
                result = result - numbers[i]
            }
        }
        return result
    }
    fun multiply(vararg numbers:Int):Int{
        var result : Int = 1
        numbers.forEach {
            if(it != 0){
                result = result * it
            }
        }
        return result
    }
    fun divide(vararg numbers:Int):Int{
        var result : Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            if(index != 0) { // result의 초기값을 이미 numbers[0]으로 줬기 때문에
                if (value != 0) {
                    result = result / value
                }
            }
            // if(index!=0 && value!=0) result = result/value
        }
        return result
    }
}

class Calculator3(val initialValue:Int){ //(1)과 (2)의 단점을 보완하는 계산기
    fun plus(number:Int):Calculator3{
        val result = this.initialValue+number
        return Calculator3(result) // 리턴타입이 Calculator3는 무슨 의미인가.
        // main에서 기능을 이어서 사용할 수 있다.
    }
    fun minus(number:Int):Calculator3{
        val result = this.initialValue-number
        return Calculator3(result)
    }
    fun mulitply(number:Int):Calculator3{
        val result = this.initialValue*number
        return Calculator3(result)
    }
    fun divide(number:Int):Calculator3{
        val result = this.initialValue/number
        return Calculator3(result)
    }
}