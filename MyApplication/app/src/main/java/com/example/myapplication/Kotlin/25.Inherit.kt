package com.example.myapplication.Kotlin

// 25.상속
    // : 부모로부터 설명서(클래스)를 물려받는다.
fun main(arg: Array<String>) {
    val superCar100 : SuperCar100 = SuperCar100()
    println(superCar100.drive())
    superCar100.stop()
    println("----------------------------------")
    // SuperCar100클래스는 Car100클래스를 상속받아서 Car100클래스의 메서드를 사용할 수 있다.
    val truck100 : Truck100 = Truck100()
    //truck100.drive()
    //truck100.stop()
    // Truck100클래스는 상속받지 못해서 Car100의 메서드를 사용할 수 없다.
    println("----------------------------------")
    val bus100 : Bus100 = Bus100()
    println(bus100.drive())

}
/*
Cars클래스(자동차 대표)에서 달리는 기능과 멈추는 기능을 만들었다. 자동차의 세부항목으로 슈퍼카, 트럭, 버스에도 이러한 기능들이 반드시 있어야 한다.
이럴 때 기존에는 클래스 내부 기능들을 일일히 복사해주었는데 이런 작업을 하지 않게 도와주는 것이 바로 '상속'이다.
    --> 문제점은 아니지만 불편함이다. 코딩을 하면서 불편함은 개선되어야 하는 점이다.

일반적으로는 공통되는 기능을 가진 클래스를 만들고 각각의 클래스에 상속받는 식으로 가면 편리하다.
변수는 기본이 public, 클래스는 기본이 private이다. 그렇기 때문에 상속을 해주려면 open을 붙여줘야 한다.
 */

// 부모클래스 : Car100
// 자식클래스 : SuperCar100, Truck100, Bus100
open class Car100(){ // 상속을 '해주려면' open 키워드를 제일 앞에 적어줘야 한다.
    open fun drive():String{
        return "달린다."
        // 자식클래스에서 수정할 수 있도록 허용해주는 것이다.
        //println("달린다.")

    }
    fun stop(){

    }
}

class SuperCar100() : Car100(){ // 상속받으려면 :(콜론)과 부모클래스의 이름 그리고 ()를 적어준다.
    // 부모클래스가 가지고 있는 기능(함수)을 조금 수정할 수 있다. --> 우선 부모클래스의 함수에 접근할 수 있어야 한다.(open 키워드를 사용)
    // override를 하는 것이다.
    override fun drive() : String{ // 부모의 클래스를 덮어 쓴 것이다.
        val run = super.drive()
        return "빨리 $run"
        // (1) 부모의 기능을 수정하거나 무시하거나 할 수 있다.
    }
}

class Truck100(){

}

class Bus100() : Car100(){
    override fun drive(): String {
        return super.drive() // super는 상위 클래스(부모 클래스)를 의미한다. 이전에 this키워드를 사용한 적이 있는데 this는 본인클래스를 의미한다.
        // super.drive()는 부모의 drive()를 호출하는 것이다.
    }
}
