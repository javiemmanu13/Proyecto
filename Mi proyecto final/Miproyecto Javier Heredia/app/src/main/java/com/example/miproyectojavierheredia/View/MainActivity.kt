package com.example.miproyectojavierheredia.View

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.proyectofinal.R


class MainActivity : AppCompatActivity() {

    private lateinit var primerTexto: EditText
    private lateinit var segundoTexto: EditText
    private lateinit var botonComparar: Button
    private lateinit var resultado: TextView
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        primerTexto = findViewById(R.id.primerTexto)
        segundoTexto = findViewById(R.id.segundoTexto)
        botonComparar = findViewById(R.id.botonComparar)
        resultado = findViewById(R.id.resultado)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        botonComparar.setOnClickListener {
            val texto1 = primerTexto.text.toString()
            val texto2 = segundoTexto.text.toString()

            viewModel.compararTextos(texto1, texto2)
        }

        viewModel.resultado.observe(this, { result ->
            if (result.sonIguales) {
                resultado.text = "Los textos son iguales"
            } else {
                resultado.text = "Los textos son diferentes"
            }
        })
    }
}
