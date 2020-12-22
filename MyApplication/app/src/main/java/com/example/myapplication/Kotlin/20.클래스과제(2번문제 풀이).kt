package com.example.myapplication.Kotlin
//2) 은행계좌 만들기
//  -계좌 생성 기능(이름, 생년월일, 초기금액)
//  -잔고를 확인 하는 기능
//  -출금 기능
//  -예금 기능
fun main() {
    val account : Account1 = Account1("김형진","1998/01/29",255000)
    println(account.checkBalance())
    println(account.save(1000))
    // kotlin.Unit이라고 출력되면 그건 save메서드는 특별히 출력안하고 리턴을 안하기 때문이다.
    println(account.withdraw(135000))
    println(account.checkBalance())
    println("--------------------------------------------")
    val account2 : Account1 = Account1("김형진","980129",-2000)
    println(account2.checkBalance())
    println("--------------------------------------------")
    val account3 : Account2 = Account2("김형진","980129")
    val account4 : Account2 = Account2("김형진","980129",4000)
    println(account3.checkBalance())
    println(account4.checkBalance())
}


class Account1{
    // 초기 금액이 음수가 될 수 없도록 해야한다.
    // -> 생성자에서 검사를 해줘야 한다.
    var name:String
    var birth:String
    var balance:Int
    constructor(name:String, birth:String, balance:Int){
        // constructor부분에서 내가 기대하던 값이 들어왔는지 아닌지를 검열해줄 수 있다.
        this.name=name
        this.birth=birth
        if (balance>=0){
            this.balance = balance
        } else {
            this.balance = 0
        }
    }
    fun checkBalance():Int{
        return balance
    }

    fun withdraw(amount:Int):Boolean{
        // true는 잘 출금이 되었다, false는 안되었다.
        if(balance>=amount){
            balance -= amount
            return true
        } else {
            return false
        }
    }
    fun save(amount: Int){
        balance += amount
    }

}

class Account2(val name:String, val birth:String, var balance: Int=1000){
    // 은행에서 이벤트를 해서 계좌를 생성하는 사람에게는 1000원을 지급하겠다!!!
    // --> 디폴트값을 주자주자
    fun checkBalance():Int{
        return balance
    }

    fun withdraw(amount:Int):Boolean{
        // true는 잘 출금이 되었다, false는 안되었다.
        if(balance>=amount){
            balance -= amount
            return true
        } else {
            return false
        }
    }
    fun save(amount: Int){
        balance += amount
    }

}

class Account3(initialBalance:Int){ // 이번에는 val이나 var을 적어주지 않았는데...!
    val balance : Int = if(initialBalance>=0) initialBalance else 0
    /*
    val,var을 선언하지 않는 변수를 constructor 안에 선언할 수 있고, 그렇게 선언한 변수를 사용하는 방법
     */
    // 멤버 메서드 안에서 initialBalance는 사용못하고
    // 생성자에서 검열을 하거나 다른 멤버변수에 값을 할당할 때 검열기준으로 사용할 수 있다.
    fun checkBalance():Int{
        //return initialBalance --> 그냥 이렇게 val/var을 선언하지 않고 클래스 안에서 변수를 사용하면 오류가 난다.
        return balance
    }
}