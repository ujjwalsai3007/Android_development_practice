package com.example.listviewanotherproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class useractivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_useractivity)

        val name=intent.getStringExtra("name")
        val phonenumber=intent.getStringExtra("Phonenumber")
        val ImageID=intent.getIntExtra("imageid",R.drawable.img)


        val nametv=findViewById<TextView>(R.id.textView1)
        val phone=findViewById<TextView>(R.id.textView3)
        val imgtv=findViewById<CircleImageView>(R.id.profile_image)

        nametv.text=name
        phone.text=phonenumber
        imgtv.setImageResource(ImageID)
    }
}