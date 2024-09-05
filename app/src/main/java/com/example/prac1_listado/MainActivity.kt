package com.example.prac1_listado

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setContentView(R.layout.activity_main)
        initRecyclerView()

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCuenta = findViewById<EditText>(R.id.etCuenta)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etImagen = findViewById<EditText>(R.id.etImagen)
        val btnAgregar = findViewById<Button>(R.id.btAgregar)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val cuenta = etCuenta.text.toString()
            val correo = etCorreo.text.toString()
            val imagen = etImagen.text.toString()

            val nuevoAlumno = AlumnosClass(nombre, cuenta, correo, imagen)
            AlumnosProvider.alumnosList.plus(nuevoAlumno)

            etNombre.text.clear()
            etCuenta.text.clear()
            etCorreo.text.clear()
            etImagen.text.clear()

            initRecyclerView()
        }
    }

    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerAlumnos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AlumnosAdapter(AlumnosProvider.alumnosList)
    }



}