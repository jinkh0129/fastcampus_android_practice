package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
/*
<AddView 사용법>
준비물 : Activity 1개(kt파일, xml파일) + xml파일
 1. 리스트로 만들고 싶은 아이템의 리스트를 준비한다.
    --> 여기서는 class와 for문을 통해서 아이템의 리스트를 준비했다.
 2. 인플레이터를 준비한다.
    --> val inflater = LayoutInflater.from(this@AddViewOwnPracticeActivity)
 3. 인플레이터로 아이템 하나에 해당하는 뷰를 만들어 준다.
    --> val itemView = inflater.inflate(R.layout.item_view, null)
 4. 위에서 만든 뷰를 컨테이너 뷰에 붙여준다.
    --> container.addView(itemView)
 */
class AddViewOwnPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view_own_practice)
        val rankList = ArrayList<Race>()
        for (i in 0 until 100){
            rankList.add(Race("선수"+i,""+i+"위"))
        }
        // 아이템의 리스트를 준비한다.

        val container = findViewById<LinearLayout>(R.id.addView_container)
        // 액티비티의 xml파일에 만든 container를 가져온다.

        val inflater = LayoutInflater.from(this@AddViewOwnPracticeActivity)
        // 인플레이터를 준비한다.

        for(i in 0 until rankList.size){
            val itemView = inflater.inflate(R.layout.item_view,null)
            // 준비한 인플레이터로 아이템 1개에 해당하는 뷰를 만들어 준다.

            val nameView = itemView.findViewById<TextView>(R.id.race_name)
            val rankView = itemView.findViewById<TextView>(R.id.race_rank)
            nameView.setText(rankList.get(i).name)
            rankView.setText(rankList.get(i).rank)
            // 아이템 1개에 해당하는 뷰에 값을 넣어준다.

            container.addView(itemView)
            // 위에서 만든 뷰를 컨테이너 뷰에 붙여준다.
        }


    }
}

class Race(val name:String, val rank:String){

}