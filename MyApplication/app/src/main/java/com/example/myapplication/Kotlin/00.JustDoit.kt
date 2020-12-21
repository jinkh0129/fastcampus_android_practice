package com.example.myapplication.Kotlin

fun main() {
    var a = mutableMapOf<String,Any>("name" to "KHJ","age" to 23,"hobby" to "coding","school" to "Hanyang Univ.")
    println(a.get("school"))
    println(a["age"])
    println("My name is ${a["name"]} and ${a["age"]} years old.\nMy hobby is ${a["hobby"]}, and My school is ${a["school"]}")


    for (item in a.keys){
        println("Key : $item")
    }
    println("----------------------------------------------")
    for (item in a.values){
        println("Value : $item")
    }

    val b = mutableListOf<Int>(100,10,12,13,5,12,165,45,31,51,2,51)
    for ((index,it) in b.withIndex()){
        println("Index is ${index}\nValue is ${it}")
        println("--------")
    }

    val fixed : Int
    var non_fixed : Int

    fixed = 100
    non_fixed = 200


}