package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Corrected variable name
        val listView = findViewById<ListView>(R.id.listView)

        // Populating the list
        val lists = arrayListOf(
            "Write exam 1",
            "Write exam 2",
            "Write exam 3",
            "Write exam 4",
            "Write exam 5",
            "Write exam 6",
            "Write exam 7"
        )

        // Setting up the adapter
        val adapterList = ArrayAdapter(this, android.R.layout.simple_list_item_1, lists)
        listView.adapter = adapterList

        // Handling item clicks
        listView.setOnItemClickListener { parent, view, position, id ->
            if (view is TextView) {
                val text = "Clicked on item: ${view.text}"
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}