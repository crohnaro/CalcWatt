package com.marlonncarvalhosa.calcwatt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CalculoAcitivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val botaoCalculo = findViewById<Button>(R.id.fazercalculo)
        botaoCalculo.setOnClickListener{
            fazerCalculo()
        }


    }
    fun fazerCalculo() {
        val estado = findViewById<EditText>(R.id.escrevaOEstado)
        val estadoString = estado.text.toString()
        val KwMesAnterior = findViewById<EditText>(R.id.hwmesanterior1)
        val KwMesAtual = findViewById<EditText>(R.id.hwmesatual1)
        val kwMesAnteriorDouble = KwMesAnterior.toString().toDouble()
        val kwMesAtualDouble = KwMesAtual.toString().toDouble()
        val BandeiraVermelha = 3.971
        val BandeiraAmarela = 1.874
        var precoEstado = 0.000

        if (estadoString == "RJ") {
            precoEstado = 0.694
        } else if (estadoString == "SP") {
            precoEstado = 0.594
        } else if (estadoString == "MG") {
            precoEstado = 0.618
        } else if (estadoString == "ES") {
            precoEstado = 0.611
        } else if (estadoString == "AM") {
            precoEstado = 0.804
        } else if (estadoString == "PA") {
            precoEstado = 0.766
        } else if (estadoString == "RR") {
            precoEstado = 0.580
        } else if (estadoString == "AP") {
            precoEstado = 0.594
        } else if (estadoString == "MA") {
            precoEstado = 0.594
        } else if (estadoString == "PI") {
            precoEstado = 0.594
        } else {
            precoEstado = 0.594
        }

        val CalculoTeste = kwMesAtualDouble - kwMesAnteriorDouble
        val CalculoTeste2 = CalculoTeste * precoEstado
        val CalculoAmarelo = CalculoTeste2 * BandeiraAmarela
        val CalculoVermelho = CalculoTeste2 * BandeiraVermelha
        val CalculoBaseString = CalculoTeste2.toString()
        val CalculoAmarelaString = CalculoAmarelo.toString()
        val CalculoVermelhoString = CalculoVermelho.toString()

        val intent = Intent(this, ResultadoActivity::class.java).also {
            it.putExtra("BandeiraVerde", CalculoBaseString)
            it.putExtra("BandeiraAmarela", CalculoAmarelaString)
            it.putExtra("BandeiraVermelha", CalculoVermelhoString)
        }


    }
}
