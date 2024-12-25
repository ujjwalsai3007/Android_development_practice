package com.example.exam_dialogue

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exam_dialogue.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            var options= arrayOf("Cricket","Football","Badminton")
            var builder1=AlertDialog.Builder(this)
            builder1.setTitle("Virat Kohli")
            builder1.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"You have selected ${options[which]}",Toast.LENGTH_SHORT).show()

            })
            builder1.setPositiveButton("submit",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show()
            })
            builder1.show()
        }
        binding.button2.setOnClickListener {
            var options= arrayOf("Cricket","Football","Badminton")
            var builder2=AlertDialog.Builder(this)
            builder2.setTitle("Ronaldo")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"You have selected ${options[which]}",Toast.LENGTH_SHORT).show()

            })
            builder2.setPositiveButton("submit",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }
        binding.button3.setOnClickListener {
            var builder3=AlertDialog.Builder(this)
            builder3.setTitle("Are you sure?")
            builder3.setMessage("Do you want to close the app")
            builder3.setPositiveButton("YES",DialogInterface.OnClickListener { dialog, which ->
                finish()
            })
            builder3.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->

            })
            builder3.show()

        }


    }
}