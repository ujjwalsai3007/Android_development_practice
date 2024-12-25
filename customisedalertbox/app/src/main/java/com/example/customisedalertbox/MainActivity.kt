package com.example.customisedalertbox

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.DataInput

class MainActivity : AppCompatActivity() {
    //create a variable of type dialog

    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        dialog=Dialog(this)
        dialog.setContentView(R.layout.custom_dailogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alertbox))

        var main=findViewById<Button>(R.id.mainbutton)

        var feedback=dialog.findViewById<Button>(R.id.btnFeedback)
        var good=dialog.findViewById<Button>(R.id.btnGood)

        good.setOnClickListener {
            dialog.dismiss()
        }
        feedback.setOnClickListener {
            Toast.makeText(this,"feedback given",Toast.LENGTH_SHORT).show()
        }

        main.setOnClickListener {
            dialog.show()
        }

    }
}