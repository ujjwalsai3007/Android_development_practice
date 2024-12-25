package com.example.day21photoframeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var currentImageIndex = 0

    // Array of image resources
    private val images = arrayOf(
        R.drawable.viratkohli,
        R.drawable.ronaldo
    )

    // Array of corresponding names
    private val names = arrayOf(
        "Virat Kohli",
        "Cristiano Ronaldo"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide Action Bar
        supportActionBar?.hide()

        // Get views
        val imageView = findViewById<ImageView>(R.id.imageView)
        val prevButton = findViewById<ImageButton>(R.id.imgPrev)
        val nextButton = findViewById<ImageButton>(R.id.imgNext)
        val textView = findViewById<TextView>(R.id.textView)

        // Set initial image and name
        imageView.setImageResource(images[currentImageIndex])
        textView.text = names[currentImageIndex]

        // Set click listeners for navigation buttons
        prevButton.setOnClickListener {
            currentImageIndex = (images.size + currentImageIndex - 1) % images.size
            imageView.setImageResource(images[currentImageIndex])
            textView.text = names[currentImageIndex]
        }

        nextButton.setOnClickListener {
            currentImageIndex = (currentImageIndex + 1) % images.size
            imageView.setImageResource(images[currentImageIndex])
            textView.text = names[currentImageIndex]
        }
    }
}
