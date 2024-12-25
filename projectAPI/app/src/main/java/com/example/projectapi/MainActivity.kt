package com.example.projectapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myadapter: Myadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        recyclerView = findViewById(R.id.recyclerView)

        // Setup Retrofit
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api::class.java)

        // API call
        val retrofitData = retrofitBuilder.getproductdata()
        retrofitData.enqueue(object : Callback<Mydata?> {
            override fun onResponse(call: Call<Mydata?>, response: Response<Mydata?>) {
                val responseBody = response.body()
                if (responseBody != null) {
                    val productList = responseBody.products
                    myadapter = Myadapter(this@MainActivity, productList)
                    recyclerView.adapter = myadapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                } else {
                    println("Response Body is Null")
                }
            }

            override fun onFailure(call: Call<Mydata?>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}