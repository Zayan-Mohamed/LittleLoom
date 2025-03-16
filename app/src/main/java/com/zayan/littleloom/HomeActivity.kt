package com.zayan.littleloom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zayan.littleloom.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle "Get Started" button click
        binding.getStartedButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Handle "I have an account" button click
        binding.haveAccountButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}