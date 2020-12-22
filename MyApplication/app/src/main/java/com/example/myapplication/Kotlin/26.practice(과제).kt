package com.example.myapplication.Kotlin

import java.time.Month

// 과제
// Nights, Monsters(부모) --> Character클래스로 변경해버리자
// SuperNights, SuperMonsters(자식)
// 상속을 이용해서 게임을 만들어보기

fun main() {
    val moster : SuperMonsters = SuperMonsters(100,10)
    val night = SuperNights(130,8)
    moster.attack(night)
    moster.bite(night)
}

/*
<상속이 만들어낸 특징>
    -자식 클래스는 부모 클래스의 타입이다. / 역은 성립하지 않는다.
    -SuperNights의 타입은 Charactor이기도 하다.
 */

open class Charactor(var hp:Int, val power: Int){
    fun attack(charactor : Charactor, power: Int=this.power){ // 클래스 멤버인 power를 가져오고 싶으면 this.를 붙여줘야 한다.
        charactor.defense(power) // 여기의 power는 attack 매개변수인 power를 의미한다.
    }
    open fun defense(damage:Int){
        hp = hp - damage
        if(hp>0){
            println("${javaClass.simpleName}의 남은 체력 $hp 입니다.")
            // 클래스의 이름을 가져오고 싶을 때는 ${javaClass.simpleName}을 사용한다.
        } else {
            println("사망했습니다.")
        }
    }
}

// 자식 클래스가 인스턴스화 되기 위해서는 부모 클래스가 선행되어서 인스턴스화가 되어야 한다.
// 즉 SuperMonsters를 만드려면 Monsters를 만들어야 한다.
class SuperMonsters(hp:Int,power:Int) : Charactor(hp, power){
    // 부모의 생성자와 자식의 생성자가 동일한 경우
    // 부모 생성자에서 넘어온 프로퍼티는 val/var을 적어주면 안된다. 왜냐하면 부모클래스에 이미 적혀있기 때문이다.
    // 자식 생성자에서 새로 생기는 프로퍼티에만 val/var을 적어준다.

    // 물어뜯기 기능을 추가하자
    fun bite(charator: Charactor){
        super.attack(charator, power + 2)
    }
}

class SuperNights(hp: Int,power: Int) : Charactor(hp, power){
    val defensePower = 2 // 2만큼 방어를 해주는 기능
    override fun defense(damage: Int) {
        super.defense(damage-defensePower)
    }
}