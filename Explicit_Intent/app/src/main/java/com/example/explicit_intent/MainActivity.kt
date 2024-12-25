package com.example.explicit_intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate: MainActivity started")
        setContentView(R.layout.activity_main)

        val btnIntent = findViewById<Button>(R.id.button)
        btnIntent.setOnClickListener {
            Log.d("MainActivity", "Button clicked, starting MainActivity2")
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
