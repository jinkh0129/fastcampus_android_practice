package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for(i in 0 until 100){
            carList.add(CarForList(""+i+"번째 자동차",""+i+"순위 엔진"))
        }
        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter = adapter
        
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name// 해당 번째 리스트가 나온다.
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this@ListViewActivity,carName+" "+carEngine,Toast.LENGTH_SHORT).show()
        }
    }
}


class ListViewAdapter(
    val carForList : ArrayList<CarForList>,
    val layoutInflater : LayoutInflater
) : BaseAdapter(){ // adapter를 쓰려면 BaseAdapter클래스를 상속받아야한다. 상속받으면 BaseAdapter 클래스의 메서드를 구현해줘야한다.
    override fun getCount(): Int { // adapter가 화면에 보여줄 갯수를 정해야 하는데 그럴려면 전체의 갯수를 알아야한다.
        // 그리고자 하는 아이템 리스트의 전체 갯수
        return carForList.size // 가지고 있는 리스트의 숫자를 알려준다.
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나(포지션에 해당)
        return carForList.get(position) // 리스트를 1개만 알려주면 된다, position은 리스트 뷰의 순서이다.
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션의 위치에 있는 아이템뷰의 ID 설정
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // 리스트를 그리게 되면 1개씩 id를 부여해줘야하는데, 여기서 부여를 해줄 수 있다.
        // 아이디를 position으로 해주겠다는 의미
        //
        val view = layoutInflater.inflate(R.layout.item_view, null)



        val carNameTextView = view.findViewById<TextView>(R.id.car_name)
        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)




        carNameTextView.setText(carForList.get(position).name)
        carEngineTextView.setText(carForList.get(position).engine)

        return view // addView의 메서드를 사용해서 추가하는 대신에 listView에서는 return을 해주면 된다.
//------------------------------------------------------------------------------------------------------------------------------------------------------------
//        val view : View
//        val holder : RecyclerView.ViewHolder
//        if(convertView == null){
//            view = layoutInflater.inflate(R.layout.item_view,null)
//            holder = RecyclerView.ViewHolder()
//            holder.carName = view.findViewById(R.id.car_name)
//            holder.carEngine = view.findViewById(R.id.car_engine)
//
//            view.tag = holder
//        } else {
//            holder = convertView.tag as RecyclerView.ViewHolder
//            view = convertView
//        }
//        holder.carName?.setText(carForList.get(position).name)
//        holder.carEngine?.setText(carForList.get(position).engine)
    }
}

class viewHolder{
    val carName:TextView? = null
    var carEngine:TextView? = null
}