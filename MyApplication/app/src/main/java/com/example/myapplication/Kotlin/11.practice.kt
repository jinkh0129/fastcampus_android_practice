package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    val value : Int? = null
    when (value){
        null->println("value is null")
        else->println("value is not null")
    }

    val value2 : Boolean? = null
    when(value2){ // when 구문을 사용할 때는 가능한 모든 경우의 수에 대해 대응해주는 것이 좋다.
        true->{
            println("")
        }
        false->{
            println("")
        }
        null->{
            println("")
        }
    }

    val value3 = when(value2){
        true->1
        false->2
        else->"DICKHEAD"
    }
    // when을 사용하여 return을 할 경우에도 모든 경우의 수를 고려해주어야 하므로 else를 적어줘 좀.

    // when의 다양한 조건식(1)
    val value4 : Int = 10
    when(value4) {
        is Int -> { // is는 type을 물어보는 키워드
            println("value4 is Int")
        }
        else -> {
            println("value4 is not Int")
        }
    }
    // when의 다양한 조건식(2)
    val value5 : Int = 87
    when(value5){
        in 60..70->{
            println("value5 is between 60 and 70.")
        }
        in 70..80->{
            println("value5 is between 70 and 80.")
        }
        in 80..90->{
            println("value5 is between 80 and 90.")
        }
    }
}