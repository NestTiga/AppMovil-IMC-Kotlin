package com.tigasinestor.imcDesarrollo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.tigasinestor.appnest.R

class ImcNestorTigasiActivity : AppCompatActivity() {

    // variables de calculo o funcionamiento
    private var mujerSeleccionada:Boolean=true
    private var altura:Int=120
    private var peso:Int=70
    private var edad:Int=25

    // Componentes
    private lateinit var cvHombre: CardView // el lateinit es para inicializar luego
    private lateinit var cvMujer: CardView
    private lateinit var txtAltura: TextView
    private lateinit var rngAltura: RangeSlider
    private lateinit var txtPeso: TextView
    private lateinit var btnMasPeso: FloatingActionButton
    private lateinit var btnMenosPeso: FloatingActionButton
    private lateinit var txtEdad: TextView
    private lateinit var btnMasEdad: FloatingActionButton
    private lateinit var btnMenosEdad: FloatingActionButton
    private lateinit var btnCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_nestor_tigasi)

        // inicialización de componente

        initComponentes()
        initListener()
    }

    private fun initComponentes(){
        cvHombre=findViewById(R.id.cvHombre)
        cvMujer=findViewById(R.id.cvMujer)

        txtAltura=findViewById(R.id.txtAltura)
        txtAltura.text="${altura.toString()} cm"
        rngAltura=findViewById(R.id.rngAltura)


        btnMasPeso=findViewById(R.id.btnMasPeso)
        txtPeso=findViewById(R.id.txtPeso)
        txtPeso.text="${peso.toString()} kg"
        btnMenosPeso=findViewById(R.id.btnMenosPeso)

        txtEdad=findViewById(R.id.txtEdad)
        txtEdad.text=edad.toString()
        btnMasEdad=findViewById(R.id.btnMasEdad)
        btnMenosEdad=findViewById(R.id.btnMenosEdad)

        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListener(){
        cvHombre.setOnClickListener { cambiarColorSexo(false) }
        cvMujer.setOnClickListener { cambiarColorSexo(true) }

        //Listener de altura
        rngAltura.addOnChangeListener { slider, value, fromUser ->
            altura=value.toInt()
            txtAltura.text="${altura.toString()} cm"
        }

        //Listener de peso
        btnMasPeso.setOnClickListener {
            if(peso<120){
                peso+=1
                setPeso()
            }
        }
        btnMenosPeso.setOnClickListener {
            if(peso>30){
                peso-=1
                setPeso()
            }
        }

        //Listener de edad
        btnMasEdad.setOnClickListener {
            if(edad<120){
                edad+=1
                setEdad()
            }
        }
        btnMenosEdad.setOnClickListener {
            if(edad>18){
                edad-=1
                setEdad()
            }
        }

        //Calculo del IMC
        btnCalculate.setOnClickListener{
            val imc:Double = calcularIMC()
            val intent = Intent(this,ResultadoImcByTigasiNestorActivity::class.java)
            intent.putExtra("IMC",imc)
            startActivity(intent)
        }

    }


    private fun setPeso(){
        txtPeso.text="${peso.toString()} kg"
    }
    private fun setEdad(){
        txtEdad.text=edad.toString()
    }

    fun cambiarColorSexo(esMujer:Boolean){
        if(esMujer){
            cvMujer.setCardBackgroundColor(ContextCompat.getColor(this,R.color.imcM_card_selected)) // el contextcompat me permite trabajar sobre el color del elemento
            cvHombre.setCardBackgroundColor(ContextCompat.getColor(this,R.color.imcM_card_noselected))
            mujerSeleccionada = true
        }else{
            cvMujer.setCardBackgroundColor(ContextCompat.getColor(this,R.color.imcM_card_noselected))
            cvHombre.setCardBackgroundColor(ContextCompat.getColor(this,R.color.imcM_card_selected))
            mujerSeleccionada = false
        }
    }

    private fun calcularIMC():Double{
        val pesoDouble:Double=peso.toDouble()
        val alturaDouble:Double = (altura.toDouble())/100
        return pesoDouble / (alturaDouble*alturaDouble)
    }

}