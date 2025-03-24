package com.zayan.littleloom

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var passwordInput: TextInputEditText
    private lateinit var passwordStrengthText: TextView
    private lateinit var registerButton: Button
    private lateinit var signInButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize views
        passwordInput = findViewById(R.id.passwordInput)
        passwordStrengthText = findViewById(R.id.passwordStrengthText)
        registerButton = findViewById(R.id.registerButton)
        signInButton = findViewById(R.id.signInButton)

        // Password strength checker
        passwordInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                checkPasswordStrength(s.toString())
            }
        })

        // Register button click listener
        registerButton.setOnClickListener {
            Toast.makeText(this, "Register button clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Login button click listener
        signInButton.setOnClickListener {
            Toast.makeText(this, "Sign In clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Function to check password strength
    private fun checkPasswordStrength(password: String) {
        val strength = when {
            password.length < 6 -> "Weak"
            password.length < 10 -> "Medium"
            else -> "Strong"
        }
        passwordStrengthText.text = "Password Strength: $strength"
    }
}