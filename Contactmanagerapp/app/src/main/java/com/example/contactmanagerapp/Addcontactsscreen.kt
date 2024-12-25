package com.example.contactmanagerapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactmanagerapp.databinding.ActivityAddcontactsscreenBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Addcontactsscreen : AppCompatActivity() {

    private lateinit var binding: ActivityAddcontactsscreenBinding
    private lateinit var database: DatabaseReference
    private lateinit var uniqueId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddcontactsscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uniqueId = intent.getStringExtra("UNIQUE_ID").toString()
        database = FirebaseDatabase.getInstance().getReference("CONTACTS")
        binding.saveContact.setOnClickListener {
            val contactName = binding.contactName.text.toString()
            val contactPhone = binding.contactPhone.text.toString()

            if (contactName.isEmpty() || contactPhone.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val contactId=database.push().key
            val contact=Contact(contactName,contactPhone)
            if (contactId != null) {
                database.child(uniqueId).child(contactId).setValue(contact).addOnSuccessListener {
                    Toast.makeText(this, "Contact Saved Successfully", Toast.LENGTH_SHORT).show()
                    binding.contactName.text?.clear()
                    binding.contactPhone.text?.clear()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed to save contact", Toast.LENGTH_SHORT).show()
                }



        }


    }
}
data class  Contact(
    val name:String,val phone:String
)}