package com.example.myapplication.Kotlin
//3) TV 클래스
//  -on/off 기능
//  -채널을 돌리는 기능
//  -초기 채널은(S사, M사, K사 3개)
fun main(array: Array<String>) {
    //val channels = listOf<String>("K","M","S")
    //val tv : TV = TV(channels)

    val tv = TV(listOf<String>("K","M","S"))
    tv.switch()
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.currentChannelNumber


}

class TV(val channels : List<String>){
    //채널을 리스트로 받겠다.
    var onOrOff : Boolean = false // true인 경우에는 On, false인 경우에는 off
    // up과Down함수에서는 인덱스 값이 계속 올라가서 나중에는 범위를 나가는 일이 생긴다. 그래서 문제해결을 위해 변수를 설정할 때 최대 인덱스 다음에는 처음 인덱스로 돌아가도록 해야한다.
    var currentChannelNumber = 0
        set(value) { // set함수는 해당 변수의 변화를 포착할 수 있다. (포착하고자 하는 변수 아래에 써야한다)
            // set함수는 currentChannelNumber라는 변수에 값이 할당될 때 실행이 된다.
            //currentChannelNumber = value --> 이렇게 currentChannelNumber에 값을 또 할당을 해주면 set은 또 실행이 된다. 즉 무한루프에 빠지게 된다. 무한루프를 피하면서 값을 할당하고 싶으면 field키워드를 사용
            field = value
            if (field > 2) {
                field = 0
            } // 채널을 올리면서 최대 인덱스를 넘어가면 다시 처음으로
            if (field < 0) {
                field = 2
            } // 채널을 내리면서 최소 인덱스를 넘어가면 다시 위로
        }
        get(){ // 변수가 불려나갈 때 실행된다.
            println("호출되었습니다.")
            return field + 1
        }
    fun switch(){ // 실행할 때마다 on/off가 번갈아겨면서
        onOrOff = !onOrOff
    }
    fun channelUp(){
        // 초기에는 처음값인 K 채널로 설정되어있고 점점 뒤로 설정되도록(index이용)
        channels.forEachIndexed { index, value ->
            if(currentChannelNumber == index){
                currentChannelNumber = currentChannelNumber+1
                return // 함수를 빠져나간다
            }
            // 현재 채널이 인덱스값과 같다면 채널을 올려준다.
        }
        // currentChannelNumber=currentChannelNumber+1 그냥 이렇게써도 되는데...
    }
    fun checkCurrentChannel():String{
        return channels[currentChannelNumber]
    }

    fun channelDown(){
        channels.forEachIndexed { index, value ->
            if(currentChannelNumber == index){
                currentChannelNumber = currentChannelNumber - 1
                return
            }
        }
        // currentChannelNumber=currentChannelNumber-1 그냥 이렇게써도 되는데...

    }
}