package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val channelid="Channel ID"
    val channelname="Channel Name"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        @RequiresApi(Build.VERSION_CODES.O)
        fun createnotificationchannel(){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.0){
                val channel= NotificationChannel(channelid,channelid,NotificationManager.IMPORTANCE_DEFAULT).apply { this }

            }
        }
    }
}