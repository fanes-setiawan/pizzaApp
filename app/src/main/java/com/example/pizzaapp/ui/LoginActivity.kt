package com.example.pizzaapp.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzaapp.MainActivity
import com.example.pizzaapp.R

class LoginActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var txtUsername: EditText
    private lateinit var txtPassword: EditText
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        // Initialize views
        btnLogin = findViewById(R.id.btnLogin)
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)

        // Set click listener for login button
        btnLogin.setOnClickListener {
            val email = txtUsername.text.toString().trim()
            val password = txtPassword.text.toString().trim()

            // Basic validation (check for empty fields)
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simulate login (replace with your actual logic)
            val loginSuccessful = email == "valid@example.com" && password == "secret"

            if (loginSuccessful) {
                // Login successful - show toast and move to another activity
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Login failed - show toast
                Toast.makeText(this, "Login Failed, Try Again !!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
