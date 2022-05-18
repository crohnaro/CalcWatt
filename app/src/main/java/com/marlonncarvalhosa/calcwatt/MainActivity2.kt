package com.marlonncarvalhosa.calcwatt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity2 : AppCompatActivity() {

    lateinit var option : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       option = findViewById(R.id.cidadesescolha) as Spinner

       val options = arrayOf("RJ", "SP","MG","ES","AM")
       option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}