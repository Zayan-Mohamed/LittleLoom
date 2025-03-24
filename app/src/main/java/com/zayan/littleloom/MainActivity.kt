package com.example.littleloom

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zayan.littleloom.R

class MainActivity : AppCompatActivity() {

    private lateinit var tvPageTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        tvPageTitle = findViewById(R.id.tvPageTitle)

        // Set up bottom navigation
        val navView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        val navController = findNavController(R.id.nav_host_fragment)

        // Connect the bottom navigation with navigation controller
        navView.setupWithNavController(navController)

        // Update toolbar title when destination changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            tvPageTitle.text = destination.label
        }
    }
}