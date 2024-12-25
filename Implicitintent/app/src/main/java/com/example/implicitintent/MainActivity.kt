package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.cardview.widget.CardView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.implicitintent.ui.theme.ImplicitintentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webutton=findViewById<CardView>(R.id.cardweb)
        val camerabutton=findViewById<CardView>(R.id.cardcamera)

        webutton.setOnClickListener() {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://www.google.com/webhp?hl=en&ictx=2&sa=X&ved=0ahUKEwi-7uuLuqSKAxWG2TgGHUpILuQQPQgJ")
            startActivity(intent)
        }

        camerabutton.setOnClickListener() {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)

        }
    }
}