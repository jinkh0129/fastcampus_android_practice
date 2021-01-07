package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList: ArrayList<CarForList> = ArrayList()
        for (i in 0..100) {
            carList.add(CarForList("" + i + "번째 자동차", "" + i + "등급 엔진"))
        }
        val damnAdapter =
            RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        recyclerview.adapter = damnAdapter
        recyclerview.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
//        recyclerview.layoutManager = GridLayoutManager(this@RecyclerViewActivity,2)
    }
}

class RecyclerViewAdapter(
    val itemList: ArrayList<CarForList>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carName: TextView
        val carEngine: TextView

        init {
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)

            itemView.setOnClickListener {
                val position: Int = adapterPosition // position을 가지고 있는 변수
                val engineName = itemList.get(position).engine
                // itemList는 RecyclerViewAdapter에 있어서 사용하려면 inner를 붙여줘야 한다.
                // inner를 붙이면 ViewHolder에 inner를 붙이면 RecyclerViewAdapter에 속해있다는 것을 알려줘서
                // RecyclerViewAdapter클래스 안의 멤버에 접근이 가능하다.
                Log.d("engine", engineName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}

class CarForList(val name: String, val engine: String) {

}