package com.example.uanpendingtask

import java.util.*

data class Task(
    val name: String,
    val description: String,
    val dueDate: String // Asegúrate de que este formato sea "dd/MM/yyyy"

) {
    fun getDaysRemaining(): Int {
        val currentDate = Calendar.getInstance()

        // Asegúrate de que el formato de la fecha sea correcto
        val dueDateParts = dueDate.split("/")
        if (dueDateParts.size != 3) {
            throw IllegalArgumentException("Fecha de entrega inválida. Formato esperado: dd/MM/yyyy")
        }

        val dueYear: Int
        val dueMonth: Int
        val dueDay: Int

        try {
            dueYear = dueDateParts[2].toInt()
            dueMonth = dueDateParts[1].toInt() - 1 // Los meses son 0-indexados
            dueDay = dueDateParts[0].toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Fecha de entrega inválida. Asegúrate de que sea un número.")
        }

        val dueCalendar = Calendar.getInstance().apply {
            set(dueYear, dueMonth, dueDay)
        }

        val diffInMillis = dueCalendar.timeInMillis - currentDate.timeInMillis
        return (diffInMillis / (1000 * 60 * 60 * 24)).toInt() // Convertir a días
    }
}






