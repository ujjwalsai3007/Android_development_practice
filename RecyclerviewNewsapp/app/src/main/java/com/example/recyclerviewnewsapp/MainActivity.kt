package com.example.recyclerviewnewsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.one)

        // Data arrays
        val imagesArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
        )

        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing"
        )

        val newsContentArray = arrayOf(
            getString(R.string.news_content_1),
            getString(R.string.news_content_2),
            getString(R.string.news_content_3),
            getString(R.string.news_content_4),
            getString(R.string.news_content_5),
            getString(R.string.news_content_6)
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf()

        // Populate news list
        for (i in imagesArray.indices) {
            val news = News(newsHeadingArray[i], imagesArray[i], newsContentArray[i])
            newsArrayList.add(news)
        }

        val adapter = myadapter(newsArrayList, this)
        myRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : myadapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                val intent = Intent(this@MainActivity, Newsdetailacttivity::class.java)
                intent.putExtra("newsHeading", newsArrayList[position].newHeading)
                intent.putExtra("newsImage", newsArrayList[position].newsImage)
                intent.putExtra("newsContent", newsArrayList[position].newsContent)
                startActivity(intent)
            }
        })
    }
}
