package com.example.interactiveapp2

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by their IDs
        val buttonYellow = findViewById<Button>(R.id.buttonYellow)
        val buttonBlack = findViewById<Button>(R.id.buttonBlack)
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)

        // Set the background to yellow when buttonYellow is clicked
        buttonYellow.setOnClickListener {
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
        }

        // Set the background to black when buttonBlack is clicked
        buttonBlack.setOnClickListener {
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        }
    }
}