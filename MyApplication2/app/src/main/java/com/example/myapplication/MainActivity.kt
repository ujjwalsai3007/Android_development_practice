package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the views
        val a = findViewById<Button>(R.id.buttonBlack)
        val b = findViewById<Button>(R.id.buttonpurple)
        val c = findViewById<LinearLayout>(R.id.linearLayout)

        // Set background to black on buttonBlack click
        a.setOnClickListener {
            c.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        }

        // Set background to purple_200 on buttonPurple click
        b.setOnClickListener {
            c.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
        }
    }
}