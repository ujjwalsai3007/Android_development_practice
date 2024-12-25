package com.example.explicit_intent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity2", "onCreate: MainActivity2 started")
        setContentView(R.layout.activity_main2)
    }
}
