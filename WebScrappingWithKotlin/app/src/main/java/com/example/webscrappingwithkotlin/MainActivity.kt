package com.example.webscrappingwithkotlin

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.view.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class MainActivity : AppCompatActivity() {

    val weburl = "https://media.daum.net/entertain"
    val TAG = "Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyAsyncTask().execute(weburl)

        rv_news_list.addItemDecoration(DividerItemDecoration(this,LinearLayout.VERTICAL))
    }

    inner class MyAsyncTask : AsyncTask<String, String, String>(){
        private var result:String =""
        var newsList:ArrayList<Item> = arrayListOf()
        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: String?): String {
            val doc: Document = Jsoup.connect("$weburl").get()
            val elts:Elements = doc.select("ul.list_feature li")

            elts.forEachIndexed{ index, elem ->
                val a_href = elem.select("a").attr("href")
                val thumb_img = elem.select("img").attr("src")
                val title = elem.select("strong.tit_thumb").text()
                Log.d(TAG,"$index $a_href / http:$thumb_img / $title")

                var mNews = Item(title, a_href, "http:"+thumb_img)
                newsList.add(mNews)
            }
            return doc.title()
        }

        override fun onPostExecute(result: String?) {
            progressBar.visibility = View.GONE
            tv_title.setText(result)

            rv_news_list.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayout.VERTICAL,false)
            var adapter = Myadapter(newsList, this@MainActivity)
            rv_news_list.adapter = adapter
        }
    }

    data class Item(val title:String, val url:String, val thumb:String)
}

class Myadapter(val items : ArrayList<MainActivity.Item>, val context : Context): RecyclerView.Adapter<Myadapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Myadapter.ViewHolder, position: Int) {
        holder.itemView.tv_title?.text = items.get(position).title
        Glide
                .with(holder.itemView.context)
                .load(items.get(position).thumb)
                .centerCrop()
                .placeholder(android.R.drawable.stat_sys_upload)
                .into(holder.itemView.tv_thumb)

        holder.itemView.setOnClickListener {
            Toast.makeText(context,"Clicked: ${items.get(position).title}",Toast.LENGTH_LONG).show()

            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(items.get(position).url)
            startActivity(context,openURL,null)
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){

    }
}