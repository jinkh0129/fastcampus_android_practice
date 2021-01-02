package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)


        val carList = ArrayList<CarForList>()
        for(i in 0 until 50){
            carList.add(CarForList(""+i+"번째 자동차",""+i+"순위 엔진"))
        }
        // 아래 과정에서 adapter클래스를 생성했으면 장착을 해야한다.
        //<1> adapter를 만든다.
        val adapter = RecylcerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        //<2> recycler_view(xml에서의 ID)에 adapter를 장착해준다.
        recycler_view.adapter = adapter
        //<3> recyclerView는 LayoutManager가 있어서 더 유연한 것이 특징인데 다음과 같이 사용한다.
        recycler_view.layoutManager = LinearLayoutManager(this@RecyclerViewActivity) // 수직 스크롤 // xml의 width(match),height(wrap)
//        recycler_view.layoutManager = GridLayoutManager(this@RecyclerViewActivity,2) // Grid(격자), spanCount는 표시할 column의 개수 // xml의 width(wrap),height(wrap) --> grid는 wrap_content를 주로 쓴다.
    }
}

//----------------------------------------------------------------------adapter를 만드는 과정--------------------------------------------------------------------

class RecylcerViewAdapter(
    val itemList : ArrayList<CarForList>,
    val inflater : LayoutInflater
) : RecyclerView.Adapter<RecylcerViewAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){//--(3)
        val carName:TextView//---------------------------------------------(1)
        val carEngine:TextView//-------------------------------------------(2)
        init { // 클래스가 생성되자마자 바로 시작되는 블록(초기화블록)
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)
            itemView.setOnClickListener {
                // click을 하면 log로 해당 번째 엔진을 뛰워주려고 한다. 그러려면 position을 알아햐한다, item의 몇 번째를 클릭했는지 알아야 해당번째의 carForList를 가져와서 맞는 순서의 Engine값을 가져오니까
                val position:Int= adapterPosition // position을 전달받을 수 있다.(adapterposition은 변수이고 position값을 가지고 있다)
                val engineName = itemList.get(position).engine // inner클래스가 상위 클래스의 변수를 사용하려면 inner키워드를 사용해서 접근할 수 있도록 해줘야한다.
                Log.d("enging",engineName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { // 뷰를 그려주는 곳
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view) // ViewHolder에 위에서 만든 view를 넣어준다
        /*
        fun onCreateViewHolder가 호출되면
        [1] 아이템 1개가 들어갈 view를 만들어 준다.
        [2] 그리고 뷰홀더에 넣어준다.-->위의 클래스에서 만든 뷰홀더
            결국 return ViewHolder(view)에 넣어준 view는 (3)의 itemView로 들어간다.
        [3] itemView가 만들어지면 init블록이 돌게된다. 그러면 carName과 carEngine의 TextView가 셋팅이된다.
        [4]그리고 fun onBindViewHolder가 호출이 되면 [3]과정에서 미리 셋팅을 한 TextView들을 불러다가 실질적으로 setText를 사용해서 넣어주는 것이다.
         */
    }

    override fun getItemCount(): Int { // 아이템 리스트 사이즈를 내보내는 곳
        return itemList.size
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // 뷰홀더를 만들고 '태그'를 달아서 찾아서 쓰는 역할(재활용)
        holder.carName.setText(itemList.get(position).name) // 뷰를 그려주는 부분(홀더에 있는 carName에 setText를 해주는 것)
        holder.carEngine.setText(itemList.get(position).engine)
        //------>(1),(2)의 홀더에 실질적인 뷰를 그려넣어주는 것이다.
    }

}