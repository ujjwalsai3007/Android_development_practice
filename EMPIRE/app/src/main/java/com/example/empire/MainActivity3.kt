package com.example.empire

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity3 : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    companion object{
       const val Key1="com.example.empire.MainActivity4.name"
       const val Key2="com.example.empire.MainActivity4.email"
       const val Key3="com.example.empire.MainActivity4.id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val signinbutton=findViewById<Button>(R.id.signin)
        val uniqueid=findViewById<TextInputEditText>(R.id.uniqueidsignin)

        signinbutton.setOnClickListener {
            val uniqueid=uniqueid.text.toString()
            if (uniqueid.isNotEmpty()){
                readdata(uniqueid)

            }else{
                Toast.makeText(this,"Please enter User Id,",Toast.LENGTH_SHORT).show()
            }
        }



    }
    private fun readdata(uniqueid : String){
        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueid).get().addOnSuccessListener {
            if(it.exists()){
                val name=it.child("name").value
                val email=it.child("mail").value
                val uniqueid=it.child("uniqueid").value

                val intent= Intent(this,MainActivity4::class.java)
                intent.putExtra(Key1,name.toString())
                intent.putExtra(Key2,email.toString())
                intent.putExtra(Key3,uniqueid.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this,"User does not exixts",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}