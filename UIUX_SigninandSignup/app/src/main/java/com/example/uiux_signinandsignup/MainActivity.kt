package com.example.uiux_signinandsignup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button view
        val click = findViewById<Button>(R.id.button)

        // Handle button click with a delay
        click.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish() // Optional: Close current activity
            }, 10) // 1-second delay
        }
    }
}
