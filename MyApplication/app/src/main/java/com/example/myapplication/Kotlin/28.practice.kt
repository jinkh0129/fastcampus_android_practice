package com.example.myapplication.Kotlin
// 인터페이스를 통해서 구현되는 내용이 비슷해서 상속을 써야하나 고민이 될 때
//--> 인터페이스를 유지하면서 문제를 해결해 나가는 방법

// **인터페이스도 구현이 있는 함수를 만들 수 있다**
// **인터페이스에 구현이 있는 함수는 그 인터페이스를 구현하는 클래스에서 그 함수를 구현할 필요가 없다**
// **인터페이스에 구현이 없는 함수는 그 인터페이스를 구현하는 클래스에서 그 함수를 반드시 구현해야 한다**

fun main() {
    val student = Student__()
    student.sleep()
    student.eat()
}
interface Person__{
    fun eat(){ // 중괄호({})를 사용해서 구현하지 않아도 된다. 구현하지 않는다면 클래스 내부에서 override를 통해 구현해주면 된다
        // 그러나 인터페이스에서 {}를 사용해서 구현을 해준다면 클래스에서 override를 통해 구현해줄 필요 없다.
        println("먹는다.")
    }
    fun sleep(){
        println("잔다.")
    }
    abstract fun study() // 인터페이스 내부의 함수에 abstract 키워드를 적으면 클래스에서 반드시 그 함수를 구현해라라는 의미다. 인터페이스에 이미 구현되어 있는 함수에도 붙일 수 있다.
}


class Student__ : Person__{
    override fun study() { // abstract가 붙어있으니 반드시 구현해줘야한다.
    }
}

class Teacher__ : Person__{
    override fun study() {
    }
}