package com.zayan.littleloom

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {

    private lateinit var passwordInput: TextInputEditText
    private lateinit var passwordStrengthText: TextView
    private lateinit var registerButton: Button
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize views
        passwordInput = findViewById(R.id.passwordInput)
        passwordStrengthText = findViewById(R.id.passwordStrengthText)
        registerButton = findViewById(R.id.registerButton)
        loginButton = findViewById(R.id.loginButton)

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
            // Add your registration logic here
        }

        // Login button click listener
        loginButton.setOnClickListener {
            // Navigate to the Main Page
            startActivity(Intent(this, MainActivity::class.java))
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

    // Sign Up text click listener
    fun onSignUpClicked(view: View) {
        Toast.makeText(this, "Sign Up clicked", Toast.LENGTH_SHORT).show()
        // Add your sign-up logic here
        // Navigate to the LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Optional: Close the current activity if needed
    }
}