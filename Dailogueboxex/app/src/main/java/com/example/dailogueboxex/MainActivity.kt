package com.example.dailogueboxex

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dailogueboxex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to close the app")
            builder1.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                    finish()
                })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener{dialog: DialogInterface?, which: Int ->

            })
            builder1.show()
        }
        binding.button2.setOnClickListener {
            val options= arrayOf("Cricket","Football","Badminton")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your fav sport?")
            //builder2.setMessage("Do you want to close the app")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener{dialogInterface, i ->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton(
                "Accept",
                DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                })
            builder2.setNegativeButton("No",DialogInterface.OnClickListener{dialog: DialogInterface?, which: Int ->

            })
            builder2.show()
        }
        binding.button3.setOnClickListener {
            val options= arrayOf("Cricket","Football","Badminton")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which is your fav sport?")
            //builder2.setMessage("Do you want to close the app")
            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            })

            builder3.setPositiveButton(
                "Accept",
                DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                })
            builder3.setNegativeButton("No",DialogInterface.OnClickListener{dialog: DialogInterface?, which: Int ->

            })
            builder3.show()
        }

    }
}