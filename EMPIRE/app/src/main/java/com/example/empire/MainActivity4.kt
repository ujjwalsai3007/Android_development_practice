package com.example.empire

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val name=intent.getStringExtra(MainActivity3.Key1)
        val email=intent.getStringExtra(MainActivity3.Key2)
        val uniqueid=intent.getStringExtra(MainActivity3.Key3)


        val welcomeText = findViewById<TextView>(R.id.tVWelcome)
        val mailText = findViewById<TextView>(R.id.tvMail)
        val idText = findViewById<TextView>(R.id.tvUnique)

        welcomeText.text = "Welcome $name"
        mailText.text = "Mail : $email"
        idText.text = "UserId : $uniqueid"

    }
}