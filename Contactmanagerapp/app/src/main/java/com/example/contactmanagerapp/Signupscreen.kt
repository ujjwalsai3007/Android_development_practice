package com.example.contactmanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.contactmanagerapp.databinding.ActivitySignupscreenBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signupscreen : AppCompatActivity() {
    lateinit var binding: ActivitySignupscreenBinding
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignupscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sign Up button click logic
        binding.signup.setOnClickListener {
            val name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val uniqueid = binding.uniqueid.text.toString()

            if (!binding.checkbox1.isChecked) {
                Toast.makeText(this, "Please accept the Terms and Conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validation for empty fields
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || uniqueid.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(name, email, password, uniqueid)
            database = FirebaseDatabase.getInstance().getReference("USERS")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "New User registered", Toast.LENGTH_SHORT).show()
                binding.name.text?.clear()
                binding.email.text?.clear()
                binding.password.text?.clear()
                binding.uniqueid.text?.clear()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to register user", Toast.LENGTH_SHORT).show()
            }
        }

        // Move "already registered" listener outside
        binding.already.setOnClickListener {
            val intent = Intent(this, Signinscreen::class.java)
            intent.putExtra("UNIQUE_ID", binding.uniqueid.text) // Pass the unique ID to the next activity
            startActivity(intent)

        }
    }
}
