package com.example.fooditemsorderplaced

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY=""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button)
        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)
        val et3=findViewById<EditText>(R.id.et3)
        val et4=findViewById<EditText>(R.id.et4)
        button.setOnClickListener {
            val orderplaced= et1.text.toString() + " " + et2.text.toString() + " " + et3.text.toString() + " " + et4.text.toString()
            intent= Intent(this,MainActivity2::class.java)
            intent.putExtra(KEY,orderplaced)
            startActivity(intent)
        }

    }
}