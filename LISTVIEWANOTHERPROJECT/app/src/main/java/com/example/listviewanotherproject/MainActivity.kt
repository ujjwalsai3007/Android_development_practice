package com.example.listviewanotherproject


import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewanotherproject.R

class MainActivity : AppCompatActivity() {
    lateinit var userarraylist: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Saumya", "Prastuti", "Ankit", "Pradeep", "Aman")
        val lastMsg = arrayOf("Hey everyone", "I am fine", "Good", "Awesome", "cool")
        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM")
        val phoneNumber = arrayOf("786453739", "986453739", "7366382829", "7383413440", "4159251517")
        val imgId = intArrayOf(R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img)

        userarraylist = ArrayList()
        for (i in name.indices) {
            val user = User(name[i], lastMsg[i], lastMsgTime[i], phoneNumber[i], imgId[i])
            userarraylist.add(user)
        }

        val listView = findViewById<ListView>(R.id.listviewid)
        listView.isClickable = true
        listView.adapter = Myadapter(this, userarraylist)

        listView.setOnItemClickListener { adapterView, view, i, l ->

            val username=name[i]
            val userphone=phoneNumber[i]
            val imgid=imgId[i]
            val intent= Intent(this,useractivity::class.java)
            intent.putExtra("name",username)
            intent.putExtra("Phonenumber",userphone)
            intent.putExtra("imageid",imgid)
            startActivity(intent)



        }
    }
}