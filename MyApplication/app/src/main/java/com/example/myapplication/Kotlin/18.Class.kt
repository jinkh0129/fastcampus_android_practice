package com.example.myapplication.Kotlin

// 18. Class 클래스
/*
<OOP (Object-Oriented Programming) : 객체 지향 프로그래밍>
- 객체란 무엇일까?
  : 이름이 있는 모든 것을 의미한다.
- 절차 지향 프로그래밍 : 코드를 위에서부터 아래로, 순서대로 실행하며 문제를 해결하는 방법이다.
- 객체 지향 프로그래밍 : 객체를 만들고 그 객체에게 일을 시켜서 문제를 해결하는 방법이다.
    --> ex) 축구 게임을 하기 위해서는 선수, 심판, 경기장, 관중 등의 객체를 만든다. 그리고 각 객체들에게 임무를 준 후 축구 게임이라는 전체적인 결과물을 만들어 낸다.
- 객체는 프레임워크가 자동적으로 만들어주지 않는다.

- 객체를 만드는 방법
    --> 객체를 어떻게 만들어야 하는지에 대한 설명서가 있어야 한다.
    --> 이러한 설명서는 코틀린을 사용하여 만든다.
    --> 이러한 설명서를 '클래스(class)'라고 부른다.
 */

fun main(array: Array<String>) {
    // 클래스(설명서)를 통해서 실체를 만드는 방법.
    // 클래스 이름을 적고 필요한 재료들을 입력해준다.
    // 클래스를 사용해 만들어진 객체를 '인스턴스화'라 하고, 그 과정을 '인스턴스화'라고 한다.
    Car("v8 engine","big")

    val bigCar=Car("v8 engine","big")
    // 객체는 변수에 담을 수 있다.
    val bigCar1 : Car = Car("v8 engine","big")
    // 우리가 만든 클래스는 자료형이 된다.

    val superCar : SuperCar = SuperCar("good engine","big","white")
    println("----------------------------------")
    val runableCar : RunableCar = RunableCar("simple engine","short body")
    // 인스턴스가 가지고 있는 기능을 사용하는 방법
    // 클래스는 설명서일 뿐 객체를 만들어야지 그 안의 기능들을 실행할 수 있다.
    // --> 마치 함수를 정의하는 것과 실행하는 것은 다르듯이
    runableCar.ride()
    runableCar.navi("부산")
    runableCar.drive()

    println("----------------------------------")

    // 인스턴스의 멤버 변수에 접근하는 방법
    val runableCar2 : RunableCar2 = RunableCar2("nice engine","long body")
    println(runableCar2.body)
    println(runableCar2.engine)

    println("----------------------------------")

    val testClass = TestClass()
    testClass.test(1)
    testClass.test(1,2)
}

// <클래스(class)를 만드는 방법(1)>
// 클래스 키워드를 입력하고 클래스의 이름을 적어준다.
// 소괄호 안에는 재료들(var enging:String, var body:String)을 정해준다.
// (1)번 방법은 (2)번 방법을 축약해서 사용하는 법이다.
class Car(var engine:String, var body:String){

}

// <클래스(class)를 만드는 방법(2)>
// 필요한 재료들을 소괄호 안이 아니라 중괄호 안에 적어줄 수 있다.
// constructor로 매개변수가 들어오고 this.를 통해 프로퍼티로 들어간다.
class SuperCar{
    var engine : String
    var body : String
    var door : String

    constructor(engine:String, body:String, door:String){
        println(engine)
        println(body)
        println(door)
        this.engine = engine // 우항의 engine은 매개변수를 통해 들어온 값을 의   미하고, 좌항의 this.engine은 클래스의 프로퍼티를 의미한다.
        this.body = body // 즉, 받아온 값을 클래스로 넣어준다는 의미다.
        this.door = door
    }
}

// <클래스(class)를 만드는 방법(3)>
// (1)번 방법의 확장
// 반드시 필요한 재료들을 적어주는 방법
// --> 반드시 필요한 재료들(engine,body)은 소괄호 안에, 추가적인 재료(door)들은 중괄호 안에 넣어준다.
// 필요재료 2개만 통해서 만드는 부분은 (ㄱ), 3개를 입력하면 (ㄴ)을 통해 만들어진다.
class Car1 constructor(engine:String, body:String){ // (ㄱ)
    // 주 생성자(클래스 바로 옆)의 constructor는 생략해도 된다. --> 여기의 생성자에는 반드시 들어가야 하는 것들이 들어간다.
    var door:String = "" // 추가재료들에는 기본값을 넣어주어야 한다.

    //생성자
    constructor(engine:String, body:String, door:String):this(engine,body){ // (ㄴ) door라는 추가재료가 들어왔을 때 만드는 방법
        // this(engine,body)는 총 3개가 들어왔을 때 engine,body는 (ㄱ) 설명서를 통해 만들고, door는 (ㄴ)의 설명서를 통해서 만든다는 것이다.
        this.door=door
    }
}

// <클래스(class)를 만드는 방법(4)>
// (2)번 방법의 확장
class Car2{
    var engine : String = ""
    var body : String = ""
    var door : String = ""

    constructor(engine: String, body: String){ // 클래스를 만드는데 있어서 필수적인 재료들을 먼저 적어준다.
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String){ // 추가적인 재료들을 사용할 때의 설명서
        this.engine = engine
        this.body = body
        this.door = door
    }
}

// 클래스 내부에 기능들을 구성하는 방법 --> 메서드(함수)
// 클래스 안의 기능은, 메서드(함수)를 의미한다.
class RunableCar(engine: String, body: String){

    fun ride(){ // 기능(1)
        println("탑승하였습니다.")
    }

    fun drive(){ // 기능(2)
        println("달립니다.")
    }

    fun navi(destination:String){ // 기능(3)
        println("${destination}으로 목적지가 설정되었습니다.")
    }
}

class RunableCar2 {
    var engine: String
    var body: String

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    init { // 클래스를 통해 인스턴스화가 될 때 init에 들어간 코드가 제일 먼저 무조건 실행이 된다.
        println("RunableCar2가 만들어 졌습니다.")
    }
    // init은 클래스를 통해 인스턴스화될 때 무조건 가장 먼저 호출되는 것이다.
    // init에서는 무엇을 하면 좋을까?
    // --> '가장 먼저'가 제일 중요한 특징이다. 그래서 초기세팅을 할 때 유용하게 사용할 수 있다.

    fun ride() {
        println("탑승하였습니다.")
    }
    fun drive() {
        println("달립니다.")
    }
    fun navi(destination:String) {
        println("${destination}으로 목적지가 설정되었습니다.")
    }
}
// 오버로딩 --> 함수의 이름이 동일할 때 처리하는 방법
// 클래스 안에는 이름이 같은 프로퍼티나 메서드가 존재할 수 없음.
// **다만 메서드의 경우 이름이 같아도 받는 인자가 다르다면 사용이 가능하다.(변수는 X)**
// --> 이름이 같지만 받는 파라미터가 다른 함수
class TestClass(){
    fun test(a:Int){
        println("up")
    }
    fun test(a:Int,b:Int){
        println("down")
    }
}