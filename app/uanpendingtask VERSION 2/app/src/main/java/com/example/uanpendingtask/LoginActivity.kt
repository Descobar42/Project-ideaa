package com.example.uanpendingtask

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailField = findViewById<EditText>(R.id.etEmail)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val registerButton = findViewById<Button>(R.id.btnRegister) // Botón de registro

        // Configuración del botón de login
        loginButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            val sharedPreferences = getSharedPreferences("userSession", MODE_PRIVATE)
            val storedPassword = sharedPreferences.getString(email, null)

            if (storedPassword != null && storedPassword == password) {
                // Login exitoso
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                // Redirigir a la MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                // Error de login
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuración del botón de registrarse
        registerButton.setOnClickListener {
            // Redirigir a la actividad de registro
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}





