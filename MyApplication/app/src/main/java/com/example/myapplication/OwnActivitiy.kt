package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class OwnActivitiy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_own_activitiy)
    }

    fun createFakeSns(fakeNumber:Int = 10, list:list_SNS= list_SNS()):list_SNS{
        for(i in 0 until fakeNumber){
            list.addSNS(SNS(""+i+"번째 SNS"))
        }
        return list
    }

    fun createSNSname(list:list_SNS){
        val layoutInflater = LayoutInflater.from(this@OwnActivitiy)
        val container = findViewById<LinearLayout>(R.id.own_container)
        for(i in 0 until list.SNSlist.size){
            val view = layoutInflater.inflate(R.layout.own_item,null)
            val snsName = view.findViewById<TextView>(R.id.name_sns)
            container.addView(view)
        }
    }
}


class list_SNS(){
    val SNSlist = ArrayList<SNS>()
    fun addSNS(sns:SNS){
        SNSlist.add(sns)
    }
}
class SNS(val name:String){

}