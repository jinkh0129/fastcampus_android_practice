package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val raceList = ArrayList<RaceForList>()
        for (i in 0..50) {
            raceList.add(RaceForList("선수" + i, "" + i + "위"))
        }

        val fuckingAdapter = ListViewAdapter(raceList, LayoutInflater.from(this))
        list_view.adapter = fuckingAdapter
    }
}

class ListViewAdapter(
    val listName: ArrayList<RaceForList>,
    val layoutInflater: LayoutInflater
) : BaseAdapter() {
    override fun getCount(): Int {
        return listName.size
    }

    override fun getItem(position: Int): Any {
        return listName.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view = layoutInflater.inflate(R.layout.item_view, null)
//        val raceNameText = view.findViewById<TextView>(R.id.race_name)
//        val raceRankText = view.findViewById<TextView>(R.id.race_rank)
//
//        raceNameText.setText(listName.get(position).name)
//        raceRankText.setText(listName.get(position).rank)
//        return view
//    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View{
        val view : View
        val holder : ViewHolder

        if(convertView == null){
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()

            holder.raceName = view.findViewById(R.id.car_name)
            holder.raceRank = view.findViewById(R.id.car_engine)
            view.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.raceName?.setText(listName.get(position).name)
        holder.raceRank?.setText(listName.get(position).rank)

        return view
    }

}

class RaceForList(val name: String, val rank: String) {

}
// 뷰홀더를 만들 때 그 안에 들어갈 값들은 null을 할당함으로써 초기화시켜줘야함.
class ViewHolder{
    var raceName: TextView? = null
    var raceRank: TextView? = null
}