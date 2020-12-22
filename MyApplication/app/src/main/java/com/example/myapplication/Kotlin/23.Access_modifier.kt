package com.example.myapplication.Kotlin

// 23.접근제어자
fun main(array: Array<String>) {
    val testAccess :TestAccess = TestAccess("아무개")
    // 클래스를 통해 객체를 생성했으면 무조건 아래 2줄의 코드는 사용가능하다.
    testAccess.test()
    //println(testAccess.name)
    //testAccess.name = "아무개2" // 값을 언제든지 바꿀 수 있음 ---> 문제있음
    // (문제)객체를 만들자마자 객체 안에있는 멤버 변수를 마음대로 바꿀 수 있음
    //println(testAccess.name)
    // ---> 만약 private을 붙여주면 접근이 불가능하다고 오류가 난다.

    val reward : Reward = Reward()
    reward.rewardAmount = 2000 // 보상을 마음대로 2000원으로 바꿀 수 있음;;
    // 이런 문제는 전역,지역변수의 개념으로 해결할 수 없다.
    //  --> 이때 가시성지시자가 필요!
    //testAccess.changeName()

    val runningCar : RunningCar = RunningCar()
    runningCar.runFast()
    //runningCar.run() --> 개발자는 run()함수를 클래스 외부에서 사용 못하게 하고 싶을 수도 있다. 이럴 때  클래스 내부의 run함수 앞에 private을 붙여준다.
}
class  Reward(){
    var rewardAmount:Int = 1000 // 우승하면 1000원을 주는 클래스라고 가정
}


class TestAccess{
    private var name: String

    //private name:String="홍길동"
    // private을 변수 앞에 붙여주면 클래스 외부에서 접근이 불가능하다.
    // 그러나 같은 클래스 안에서는 접근이 가능하다.
    private fun changeName(newName : String){ // 클래스의 메서드 앞에 private을 붙이면 클래스 외부에서도 메서드를 사용할 수 없다.
        this.name = newName
    }

    constructor(name:String){
        this.name = name
    }

    fun test(){
        println("테스트")
    }
}

class RunningCar(){  // 자동차와 관련된 클래스를 만든다고 가정
    fun runFast(){ // runFast함수 안에 들어갈 로직 중에서 run함수의 내용을 써야 할 수도 있다.

    }
    private fun run(){ // run함수는 단독적으로 쓰이지 않고, runFast의 로직에만 포함된다면 굳이 보여지지 않아도 되고, 개발자가 비밀로 하고 싶을 때도 있다. 이럴 때 private을 쓴다.
        
    }
}