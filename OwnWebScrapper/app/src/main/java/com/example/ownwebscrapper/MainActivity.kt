package com.example.ownwebscrapper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.doAsync
import org.jsoup.Jsoup
import android.net.Uri
import android.os.AsyncTask
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync {
            val doc = Jsoup.connect("https://finance.naver.com/sise/lastsearch2.nhn").get()
            val className = doc.select("div.box_type_l")
//            val tBody = className.select("tbody")
//            val tr = tBody.select("tr")[2]
//            val firmName = tr.select("a").text()
 //           val priceFirm = tr.select("td")[3].text()
//
  //          price.setText(priceFirm)
    //        name_of_firm.setText(firmName)

            price.setText(className.toString())

        }
    }
}