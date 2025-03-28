package com.zayan.littleloom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import com.zayan.littleloom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up the binding for the activity
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the toolbar
        setSupportActionBar(binding.toolbar)

        // Initialize DrawerLayout and NavigationView
        drawerLayout = binding.drawerLayout
        navigationView = binding.navigationView

        // Safely find NavHostFragment and obtain the NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            ?: throw IllegalStateException("NavHostFragment not found")
        navController = navHostFragment.navController

        // Set up ActionBarDrawerToggle
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // Setup Bottom Navigation
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNav.setupWithNavController(navController)

        // Setup Navigation View
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selections
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.navigation_home)
                    drawerLayout.close()
                    true
                }
                R.id.nav_profile -> {
                    navController.navigate(R.id.fragment_profile)
                    drawerLayout.close()
                    true
                }
                R.id.nav_settings -> {
                    navController.navigate(R.id.navigation_settings)
                    drawerLayout.close()
                    true
                }
                else -> false
            }

        }

        // Optional: Set up messages and plus buttons
        binding.messagesButton.setOnClickListener {
            // Handle messages navigation
            navController.navigate(R.id.fragment_message)
        }

        binding.plusButton.setOnClickListener {
            // Handle add/create new item
            navController.navigate(R.id.fragment_add_item)
        }
    }

    // Handle up navigation
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}