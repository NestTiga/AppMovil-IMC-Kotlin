package com.tigasinestor.imcDesarrollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.tigasinestor.appnest.R

class ResultadoImcByTigasiNestorActivity : AppCompatActivity() {

    lateinit var btnReCalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imc_by_tigasi_nestor)

        //Inicializar el botón
        btnReCalculate =findViewById(R.id.btnReCalculate)

        btnReCalculate.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        } // Activity dentro de la pila, el anterior
    }
}