package com.example.uanpendingtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.uanpendingtask.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar el layout del fragmento manualmente
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cargar información de usuario (puedes reemplazar esto por datos reales)
        val userEmail = "usuario@ejemplo.com" // Obtener de SharedPreferences o base de datos
        val userPassword = "********"         // Ocultar la contraseña
        val appDescription = "Esta aplicación te permite gestionar tus tareas del trabajo, la universidad o el colegio. ¡Organiza tu día de forma sencilla!"

        // Encontrar las vistas manualmente
        val tvEmail: TextView = view.findViewById(R.id.tvEmail)
        val tvPassword: TextView = view.findViewById(R.id.tvPassword)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)

        // Mostrar datos en la interfaz
        tvEmail.text = "Correo electrónico: $userEmail"
        tvPassword.text = "Contraseña: $userPassword"
        tvDescription.text = appDescription
    }
}


