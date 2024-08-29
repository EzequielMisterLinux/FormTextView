package com.example.forminsano

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var rgGenero: RadioGroup
    private lateinit var cbTecnologia: CheckBox
    private lateinit var cbDeportes: CheckBox
    private lateinit var cbMusica: CheckBox
    private lateinit var cbViajes: CheckBox
    private lateinit var btnRegistrar: Button
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etNombre = findViewById(R.id.etNombre)
        rgGenero = findViewById(R.id.rgGenero)
        cbTecnologia = findViewById(R.id.cbTecnologia)
        cbDeportes = findViewById(R.id.cbDeportes)
        cbMusica = findViewById(R.id.cbMusica)
        cbViajes = findViewById(R.id.cbViajes)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        tvInfo = findViewById(R.id.tvInfo)


        btnRegistrar.setOnClickListener {
            mostrarInformacion()
        }
    }

    private fun mostrarInformacion() {

        val nombre = etNombre.text.toString()


        val generoId = rgGenero.checkedRadioButtonId
        val genero = findViewById<RadioButton>(generoId)?.text.toString()


        val intereses = mutableListOf<String>()
        if (cbTecnologia.isChecked) intereses.add("Tecnología")
        if (cbDeportes.isChecked) intereses.add("Deportes")
        if (cbMusica.isChecked) intereses.add("Música")
        if (cbViajes.isChecked) intereses.add("Viajes")


        val info = StringBuilder()
        info.append("Nombre: $nombre\n")
        info.append("Género: $genero\n")
        info.append("Intereses: ${if (intereses.isEmpty()) "Ninguno" else intereses.joinToString(", ")}")


        tvInfo.text = info.toString()
        tvInfo.visibility = View.VISIBLE
        }
    }
