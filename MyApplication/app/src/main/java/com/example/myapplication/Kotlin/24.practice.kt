package com.example.myapplication.Kotlin


fun main(array: Array<String>) {
    val knight = Knight(20,4)
    val monster = Monster(15,5)
    knight.attack(monster)
    monster.attack(knight)

    //knight.hp=100 // 임의로 기사의 체력을 바꿔버리면 게임의 규칙에 어긋난다. 그래서 이런식의 접근이 불가능하게 만들어야 한다.
    //println(knight.hp) 이럴 때는 접근제어자를 붙여주면 된다.

}

class Knight(private var hp:Int, private var power:Int){
    fun attack(monster: Monster){ // 자료형을 클래스로 선언
        monster.defense(power)
    }
    fun defense(damage : Int){
        hp = hp - damage
        if(hp>0) { // 기사가 살아있다면
            heal()
            println("기사의 현재 체력은 ${hp}입니다.")
        } else println("기사가 죽었습니다.")
    }
    private fun heal(){
        // 아무때나 사용하는 것이 아니라 살아있고 공격을 받았을 때 heal을 사용하는 것이다.
        hp += 3
    }
}

class Monster(private var hp:Int,private var power:Int){
    fun attack(knight: Knight){
        knight.defense(power) // 몬스터가 공격할 때 몬스터의 power는 기사에게 있어서 defense이고 damage를 의미한다.
    }
    fun defense(damage:Int){
        hp = hp - damage
        if(hp>0) println("몬스터의 현재 체력은 ${hp}입니다.")
        else println("몬스터가 죽었습니다.")
    }
}

/*
습관적으로 이제는 클래스의 생성자에 private을 적고, val로 생성을 해줘서 최소한으로 두는 것이 좋다.
무조건 키워드(fun, val 등등)에 private을 적어주는 것이 좋다. 나중에 외부에서 사용해야 하면 그때 private을 지워주면 되니까.
 */