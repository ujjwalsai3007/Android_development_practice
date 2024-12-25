package com.example.footballapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val m=findViewById<CardView>(R.id.cardManchesterUnited)
        m.setOnClickListener {
            navigateToMainActivity3("Manchester United")
        }

        val l=findViewById<CardView>(R.id.cardLiverpool)
        l.setOnClickListener{
            navigateToMainActivity3("Liverpool")
        }

        val c=findViewById<CardView>(R.id.cardChelsea)
        c.setOnClickListener{
            navigateToMainActivity3("Chelsea")
        }

        val a=findViewById<CardView>(R.id.cardArsenal)
        a.setOnClickListener{
            navigateToMainActivity3("Arsenal")
        }

        val r=findViewById<CardView>(R.id.cardRealMadrid)
        r.setOnClickListener{
            navigateToMainActivity3("Real Madrid")
        }



    }

    fun navigateToMainActivity3(teamname:String){
        val intent =Intent(this,MainActivity3::class.java)
        intent.putExtra("TEAM_NAME", teamname)
        startActivity(intent)
    }
}