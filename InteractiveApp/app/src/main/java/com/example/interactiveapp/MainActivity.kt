package com.example.interactiveapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.interactiveapp.ui.theme.InteractiveAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val a=findViewById<Button>(R.id.buttonupload)
        val b=findViewById<Button>(R.id.buttondownload)

        a.setOnClickListener{
            Toast.makeText(applicationContext,"Uploadin....",Toast.LENGTH_LONG).show()
        }

        b.setOnClickListener{
            Toast.makeText(applicationContext,"Downloading....",Toast.LENGTH_LONG).show()
        }
    }
}



