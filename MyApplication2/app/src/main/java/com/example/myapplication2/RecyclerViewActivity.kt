package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList : ArrayList<CarForList> = ArrayList()
        for(i in 0..1000){
            carList.add(CarForList(""+i+"번째 자동차",""+i+"등급 엔진"))
        }
        val damnAdapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        recyclerview.adapter = damnAdapter
        recyclerview.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
    }
}

class RecyclerViewAdapter(
    val itemList : ArrayList<CarForList>,
    val inflater : LayoutInflater
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val carName : TextView
        val carEngine : TextView

        init {
            carName = itemView.findViewById(R.id.race_name)
            carEngine = itemView.findViewById(R.id.race_rank)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view,parent,false)
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

class CarForList(val name:String, val engine:String){

}