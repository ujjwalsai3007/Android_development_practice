package com.example.binding

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layo utInflater)
        setContentView(binding.root)
        binding.signup.setOnClickListener {
            if(binding.checkbox1.isChecked){
                val intent= Intent(this,MainActivity2::class.java)
                startActivity(intent)
        }else{
            binding.checkbox1.buttonTintList= ColorStateList.valueOf(Color.RED)
            Toast.makeText(this,"Please accept T&C",Toast.LENGTH_SHORT).show()
            }
        }
    }
}