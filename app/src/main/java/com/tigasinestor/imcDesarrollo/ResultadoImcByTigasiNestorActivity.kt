package com.tigasinestor.imcDesarrollo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tigasinestor.appnest.R
import kotlin.math.roundToInt

class ResultadoImcByTigasiNestorActivity : AppCompatActivity() {

    private lateinit var btnReCalculate: Button
    private lateinit var txtEstado: TextView
    private lateinit var txtIMC: TextView
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imc_by_tigasi_nestor)

        //Inicializar componentes
        initComponentes()
        recibirRespuesta()
        initListener()
    }


    private fun initComponentes(){
        txtEstado=findViewById(R.id.txtEstado)
        txtIMC=findViewById(R.id.txtIMC)
        btnReCalculate =findViewById(R.id.btnReCalculate)
    }

    private fun initListener(){
        btnReCalculate.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        } // Activity dentro de la pila, el anterior
    }
    private fun recibirRespuesta(){
        val respuesta:String=intent.extras?.getString("IMC").orEmpty()
        if (respuesta.isNotEmpty()){
            val respuestaDouble:Double=respuesta.toDouble()
            val respuestaRedondeado = String.format("%.2f", respuestaDouble) //  redondea los tipos float o double y resulta un string
            calcularEstado(respuestaRedondeado.toDouble())
            txtIMC.text=respuestaRedondeado
        }
    }

    private fun calcularEstado(valor:Double){
        val pesoInsuficiente:Double=18.5
        val pesoNormal:Double=24.9
        if(valor<pesoInsuficiente){
            txtEstado.text="Peso insuficiente"
        } else if (valor >= pesoInsuficiente && valor <= pesoNormal){
            txtEstado.text="Peso normal"
        }
    }



}