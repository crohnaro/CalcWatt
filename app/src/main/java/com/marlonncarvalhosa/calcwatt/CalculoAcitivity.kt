package com.marlonncarvalhosa.calcwatt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CalculoAcitivity : AppCompatActivity() {


    var precoEstado = 0.000
    var CalculokwHora : Double = 0.0
    val BandeiraVermelha = 0.30
    val BandeiraAmarela = 0.10
    var calculoBandeiraVermelha : Double = 0.0
    var calculoBandeiraAmarela : Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val estado = findViewById<EditText>(R.id.escrevaOEstado)
        val KwMesAnterior = findViewById<EditText>(R.id.hwmesanterior1)
        val KwMesAtual = findViewById<EditText>(R.id.hwmesatual1)




        val botaoCalculo = findViewById<Button>(R.id.fazercalculo)
        botaoCalculo.setOnClickListener{
            val kwMesAnteriorDouble : Double? = KwMesAnterior.text.toString().toDoubleOrNull()
            val kwMesAtualDouble : Double? = KwMesAtual.text.toString().toDoubleOrNull()
            val estadoString : String = estado.text.toString()

            estadoPrecoFun(estadoString)
            calculoConsumoAtual(kwMesAtualDouble, kwMesAnteriorDouble)
            calculoBandeira()
            fazerCalculo()
        }


    }

    fun calculoConsumoAtual(KwMesAtual : Double?, KwMesAnterior : Double?){
        if (KwMesAtual != null && KwMesAnterior != null) {
            CalculokwHora = KwMesAtual - KwMesAnterior
        }
    }

    fun calculoBandeira(){
        calculoBandeiraVermelha = precoEstado + BandeiraVermelha
        calculoBandeiraAmarela = precoEstado + BandeiraAmarela
    }

    fun fazerCalculo() {

        val taxaIluminacaoPublica = 10.0
        val CalculoBase = CalculokwHora * precoEstado + taxaIluminacaoPublica
        val CalculoAmarelo = calculoBandeiraAmarela * CalculokwHora + taxaIluminacaoPublica
        val CalculoVermelho = calculoBandeiraVermelha * CalculokwHora + taxaIluminacaoPublica
        val CalculoBaseString = CalculoBase.toFloat().toString()
        val CalculoAmarelaString = CalculoAmarelo.toFloat().toString()
        val CalculoVermelhoString = CalculoVermelho.toFloat().toString()

        val intent = Intent(this, ResultadoActivity::class.java).also {
            it.putExtra("Bandeira Verde","R$ $CalculoBaseString")
            it.putExtra("Bandeira Amarela", "R$ $CalculoAmarelaString")
            it.putExtra("Bandeira Vermelha", "R$ $CalculoVermelhoString")
            startActivity(it)
        }


    }

    private fun estadoPrecoFun(estadoString: String): Double {

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
            precoEstado = 0.505
        } else if (estadoString == "MA") {
            precoEstado = 0.642
        } else if (estadoString == "PI") {
            precoEstado = 0.628
        } else if (estadoString == "SC") {
            precoEstado = 0.532
        } else if (estadoString == "RO") {
            precoEstado = 0.546
        } else if (estadoString == "RN") {
            precoEstado = 0.559
        } else if (estadoString == "PR") {
            precoEstado = 0.559
        } else if (estadoString == "DF") {
            precoEstado = 0.575
        } else if (estadoString == "CE") {
            precoEstado = 0.589
        } else if (estadoString == "PE") {
            precoEstado = 0.619
        } else if (estadoString == "PB") {
            precoEstado = 0.619
        } else if (estadoString == "BA") {
            precoEstado = 0.620
        } else if (estadoString == "AL") {
            precoEstado = 0.626
        } else if (estadoString == "PL") {
            precoEstado = 0.628
        }
        return precoEstado
    }
}
