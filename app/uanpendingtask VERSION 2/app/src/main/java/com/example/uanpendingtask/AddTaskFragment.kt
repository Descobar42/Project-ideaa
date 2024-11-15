package com.example.uanpendingtask

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.uanpendingtask.databinding.FragmentAddTaskBinding
import java.util.*

class AddTaskFragment : Fragment() {

    private var _binding: FragmentAddTaskBinding? = null
    private val binding get() = _binding!!

    private var selectedDate: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Manejar el clic del botón de seleccionar fecha
        binding.btnSelectDate.setOnClickListener {
            showDatePicker()
        }

        // Manejar el clic del botón de agregar tarea
        binding.btnAddTask.setOnClickListener {
            val taskName = binding.etTaskName.text.toString().trim()
            val taskDescription = binding.etTaskDescription.text.toString().trim()

            // Validar que no estén vacíos
            if (taskName.isEmpty() || taskDescription.isEmpty() || selectedDate.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear la tarea y añadirla a la lista de tareas
            val task = Task(taskName, taskDescription, selectedDate)
            TaskManager.addTask(task) // Agrega la tarea a la lista

            // Mensaje de éxito
            Toast.makeText(requireContext(), "Tarea añadida: $taskName", Toast.LENGTH_SHORT).show()

            // Regresar a la pantalla del calendario
            findNavController().navigate(R.id.nav_calendar)
        }

        // Manejar el clic del botón de regresar
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack() // Regresar al fragmento anterior
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.tvSelectedDate.text = "Fecha de entrega: $selectedDate"
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}








