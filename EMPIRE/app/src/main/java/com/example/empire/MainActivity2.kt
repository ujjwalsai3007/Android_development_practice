package com.example.empire

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {
    lateinit var database: DatabaseReference // Firebase database reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val button = findViewById<Button>(R.id.signup)
        val nname = findViewById<TextInputEditText>(R.id.name)
        val mmail = findViewById<TextInputEditText>(R.id.email)
        val ppassword = findViewById<TextInputEditText>(R.id.password)
        val uuniqueid = findViewById<TextInputEditText>(R.id.uniqueid)
        val checkbox = findViewById<CheckBox>(R.id.checkbox1) // Add checkbox reference

        button.setOnClickListener {
            val name = nname.text.toString()
            val mail = mmail.text.toString()
            val password = ppassword.text.toString()
            val uniqueid = uuniqueid.text.toString()

            // Check if T&C checkbox is checked
            if (!checkbox.isChecked) {
                Toast.makeText(this, "Please accept the Terms and Conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validation for empty fields
            if (name.isEmpty() || mail.isEmpty() || password.isEmpty() || uniqueid.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save to Firebase
            val user = User(name, mail, password, uniqueid)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
                // Clear fields
                nname.text?.clear()
                mmail.text?.clear()
                ppassword.text?.clear()
                uuniqueid.text?.clear()
                checkbox.isChecked = false // Uncheck the checkbox after success
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to register user", Toast.LENGTH_SHORT).show()
            }
        }

        val already = findViewById<TextView>(R.id.textViewalready)
        already.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}
