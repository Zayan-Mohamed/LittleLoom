package com.zayan.littleloom

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var rememberMeCheckBox: CheckBox
    private lateinit var forgotPasswordTextView: TextView
    private lateinit var loginButton: Button
    private lateinit var signUpButton: Button

    private lateinit var sharedPreferences: SharedPreferences
    private val PREF_NAME = "LoginPrefs"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_REMEMBER = "remember"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize views
        initViews()

        // Load saved preferences
        loadSavedPreferences()

        // Set up click listeners
        setupListeners()
    }

    private fun initViews() {
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        rememberMeCheckBox = findViewById(R.id.checkBoxRememberMe)
        forgotPasswordTextView = findViewById(R.id.textViewForgotPassword)
        loginButton = findViewById(R.id.buttonLogin)
        signUpButton = findViewById(R.id.signUpButton)

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }

    private fun loadSavedPreferences() {
        if (sharedPreferences.getBoolean(KEY_REMEMBER, false)) {
            emailEditText.setText(sharedPreferences.getString(KEY_EMAIL, ""))
            passwordEditText.setText(sharedPreferences.getString(KEY_PASSWORD, ""))
            rememberMeCheckBox.isChecked = true
        }
    }

    private fun setupListeners() {
        loginButton.setOnClickListener {
            attemptLogin()
        }

        forgotPasswordTextView.setOnClickListener {
            navigateToForgotPassword()
        }

        // Note: onSignUpClicked is implemented separately as it's
        // referenced directly in the layout's onClick attribute
    }

    private fun attemptLogin() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Validate inputs
        if (email.isEmpty()) {
            emailEditText.error = "Email cannot be empty"
            return
        }

        if (password.isEmpty()) {
            passwordEditText.error = "Password cannot be empty"
            return
        }

        // TODO: Implement actual authentication logic here
        // For now, we'll simulate successful login

        // Save login information if "Remember Me" is checked
        if (rememberMeCheckBox.isChecked) {
            val editor = sharedPreferences.edit()
            editor.putString(KEY_EMAIL, email)
            editor.putString(KEY_PASSWORD, password)
            editor.putBoolean(KEY_REMEMBER, true)
            editor.apply()
        } else {
            // Clear preferences if remember me is unchecked
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }

        // Navigate to main activity
        navigateToMainActivity()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Close login activity
    }

    private fun navigateToForgotPassword() {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    // This method is referenced in the layout XML's onClick attribute
    fun onSignUpClicked(view: View) {
        Toast.makeText(this, "Sign Up Clicked", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}