package com.example.uanpendingtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailField = findViewById<EditText>(R.id.etEmail)
        val passwordField = findViewById<EditText>(R.id.etPassword)
        val registerButton = findViewById<Button>(R.id.btnRegister)

        registerButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            // Verificar si el correo y la contraseña no están vacíos
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Guardar el correo y la contraseña en SharedPreferences
                val sharedPreferences = getSharedPreferences("userSession", MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                // Guardar datos solo si el correo no existe previamente
                if (sharedPreferences.getString(email, null) == null) {
                    editor.putString(email, password) // Guardar correo y contraseña
                    editor.apply()

                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                    // Redirigir al LoginActivity
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "El correo ya está registrado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}



