package com.tigasinestor.appnest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.tigasinestor.imcDesarrollo.ImcNestorTigasiActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Capturamos al botón iniciar y lanzamos
        val btnIniciar= findViewById<Button>(R.id.btnIniciar)

        //Evento
        btnIniciar.setOnClickListener {
            Log.i("BOTÓN --------- ","LANZAMOS APP IMC")
            navegarHaciaApp(ImcNestorTigasiActivity::class.java)
        }

    }

    fun navegarHaciaApp(clase:Class<*>){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}