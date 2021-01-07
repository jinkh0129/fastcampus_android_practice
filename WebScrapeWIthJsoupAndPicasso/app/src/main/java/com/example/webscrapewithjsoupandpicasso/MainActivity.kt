package com.example.webscrapewithjsoupandpicasso

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.info_listview.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_listview)
        retrieveWebInfo()

    }

    fun retrieveWebInfo() {
        thread {
            val informationList = ArrayList<infoStock>()
            first@ for (number in 0..49) {
                val passNumberList = arrayListOf<Int>(
                    0,
                    1,
                    7,
                    8,
                    9,
                    15,
                    16,
                    17,
                    23,
                    24,
                    25,
                    31,
                    32,
                    33,
                    39,
                    40,
                    41,
                    47,
                    48,
                    49
                )
                val doc = Jsoup.connect("https://finance.naver.com/sise/lastsearch2.nhn").get()
                val divTag = doc.select("div.box_type_l")
                val tage = divTag.select("tr")[number]
                if (number in passNumberList) continue@first
                val nameOfCompany = tage.select("td")[1].text() // 이름
                val priceOfCompany = tage.select("td")[3].text() // 현재가
                val percentOfCompany = tage.select("td")[5].text() // 등락률
                informationList.add(
                    infoStock(
                        name = nameOfCompany,
                        price = priceOfCompany,
                        percent = percentOfCompany
                    )
                )
            }
            this.runOnUiThread {
                val fuckingAdapter =
                    fillWithListView(informationList, LayoutInflater.from(this))
                listView.adapter = fuckingAdapter
            }
        }
    }


}

class fillWithListView(
    val listName: ArrayList<infoStock>,
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

    @SuppressLint("ResourceAsColor")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()

            holder.firmName = view.findViewById(R.id.company_name)
            holder.firmPrice = view.findViewById(R.id.company_price)
            holder.firmPercent = view.findViewById(R.id.company_percent)
            view.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        val colorOfTextView = view.findViewById<TextView>(R.id.company_percent)
        holder.firmName?.setText(listName.get(position).name)
        holder.firmPrice?.setText(listName.get(position).price)
        holder.firmPercent?.setText(listName.get(position).percent)

        return view
    }
}

class infoStock(val name: String, val price: String, val percent: String) {

}

class ViewHolder {
    var firmPrice: TextView? = null
    var firmName: TextView? = null
    var firmPercent: TextView? = null
}