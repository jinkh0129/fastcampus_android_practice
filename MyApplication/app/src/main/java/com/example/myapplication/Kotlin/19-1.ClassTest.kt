package com.example.myapplication.Kotlin

fun main() {
    var test1 : calcul = calcul()
    test1.add(10,11)
    test1.minus(100,12)
    test1.sub(10,0)
    test1.sub(80,13)
    test1.mul(5,5)
    println("--------------------------------------------")

    var bank : bankAccount = bankAccount("김형진",980129)
    bank.makeAccount()
    bank.checkBalance()
    bank.deposit(100)
    bank.deposit(2000)
    bank.checkBalance()
    bank.withdraw(500)
    bank.checkBalance()
    bank.withdraw(5000)
    bank.checkBalance()
    println("--------------------------------------------")

    var person : tv = tv()
    person.on()
    person.checkChannel()
    person.addChannel("JTBC")
    person.turnChannel("Mnet")
    person.turnChannel("JTBC")
    person.off()
}

class calcul{
    //1) 사칙 연산을 수행할 수 있는 클래스
    fun add(first:Int,second:Int){
        println("first + second = ${first+second}")
    }
    fun mul(first:Int, second: Int){
        println("first x second = ${first*second}")
    }
    fun minus(first: Int, second: Int){
        println("first - second = ${first-second}")
    }
    fun sub(first: Int, second: Int){
        if(second==0){
            println("0으로는 나눌 수 없습니다.")
        } else {
            println("first / second = ${first/second}")
        }
    }
}

class bankAccount {
    //2) 은행계좌 만들기
//  -계좌 생성 기능(이름, 생년월일)
//  -잔고를 확인 하는 기능
//  -출금 기능
//  -예금 기능
    var name:String
    var birth:Int
    var balance:Int=0
    var deposit:Int=0
    var withdraw:Int=0

    constructor(name:String, birth:Int){
        this.name = name
        this.birth = birth
    }

    fun makeAccount(){
        println("${name}님 계좌가 만들어졌습니다.")
    }
    fun checkBalance(){
        println("잔고는 현재 ${balance}원 입니다.")
    }
    fun deposit(money:Int):Int{
        println("${money}원 입금하였습니다")
        balance = balance + money
        return balance
    }
    fun withdraw(money:Int):Int{
        if(balance>=money){
            println("${money}원 출금되었습니다.")
            balance = balance - money
        } else {
            println("계좌에 잔액이 부족합니다.")
        }
        return balance
    }
}

class tv(){
    //3) TV 클래스
//  -on/off 기능
//  -채널을 돌리는 기능
//  -초기 채널은(S사, M사, K사 3개)
    var channel = mutableListOf<String>("SBS","KBS","MBC")
    fun on(){
        println("TV가 켜졌습니다.")
    }
    fun off(){
        println("TV가 꺼졌습니다.")
    }
    fun checkChannel(){
        println("현재 유지 중인 채널 목록은 ${channel}입니다.")
    }

    fun addChannel(wantchannel:String){
        channel.add(wantchannel)
        println("${wantchannel}이 추가되어서 현재 유지 중인 채널 목록은 ${channel}입니다.")
    }
    fun turnChannel(wantchannel: String){
        if(wantchannel in channel){
            println("${wantchannel}로 변경하였습니다.")
        } else {
            println("${wantchannel}은 채널 목록에 없습니다.\n시청을 원하시면 추가하시길 바랍니다.")
        }
    }
}