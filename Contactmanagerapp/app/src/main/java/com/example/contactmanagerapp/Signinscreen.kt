package com.example.contactmanagerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactmanagerapp.databinding.ActivitySigninscreenBinding
import com.google.firebase.database.*

class Signinscreen : AppCompatActivity() {
    private lateinit var binding: ActivitySigninscreenBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Database reference
        database = FirebaseDatabase.getInstance().getReference("USERS")

        // Sign In Button Logic
        binding.signin.setOnClickListener {
            val uniqueid = binding.uniqueidsignin.text.toString()

            // Check if Unique ID field is empty
            if (uniqueid.isEmpty()) {
                Toast.makeText(this, "Please enter your Unique ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate Unique ID in Firebase
            database.child(uniqueid).get().addOnSuccessListener { snapshot ->
                if (snapshot.exists()) {
                    // Unique ID exists: Navigate to Addcontactsscreen
                    Toast.makeText(this, "Sign In Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Addcontactsscreen::class.java)
                    intent.putExtra("UNIQUE_ID", uniqueid) // Pass the unique ID to the next activity
                    startActivity(intent)
                } else {
                    // Unique ID not found
                    Toast.makeText(this, "Invalid Unique ID", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to connect. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
