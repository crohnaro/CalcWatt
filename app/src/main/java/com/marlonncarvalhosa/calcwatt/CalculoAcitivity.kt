package com.marlonncarvalhosa.calcwatt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class CalculoAcitivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

      val spinnerEstados : Spinner = findViewById(R.id.cidadesescolha)

       val options = arrayOf("RJ", "SP","MG","ES","AM")
        val estadosPreço = arrayOf(2, 3, 5, 6, 7)
       spinnerEstados.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options)

        spinnerEstados.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val preço = estadosPreço[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}