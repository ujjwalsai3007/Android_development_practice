package com.example.bottomnavigationviews

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val bottomview=findViewById<BottomNavigationView>(R.id.bottomnavigation)

        replacewithfragement(Home())

        bottomview.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1->replacewithfragement(Home())
                R.id.item2->replacewithfragement(Bluetooth())
                R.id.item3->replacewithfragement(Profile())
                else->{

                }

            }
            true
        }






    }

    private fun replacewithfragement(fragement:Fragment) {
        val fragementmanager=supportFragmentManager
        val fragementtransaction=fragementmanager.beginTransaction()
        fragementtransaction.replace(R.id.framelayout,fragement)
        fragementtransaction.commit()

    }
}