package com.marlonncarvalhosa.calcwatt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val BandeiraVerde = intent.getStringExtra("Bandeira Verde")
        val BandeiraVerdeTextView = findViewById<TextView>(R.id.BandeiraVerde).apply {
            text = BandeiraVerde
        }
        val BandeiraVermelha = intent.getStringExtra("Bandeira Vermelha")
        val BandeiraVermelhaTextView = findViewById<TextView>(R.id.BandeiraVermelha).apply {
            text = BandeiraVermelha
        }
        val BandeiraAmarela = intent.getStringExtra("Bandeira Amarela")
        val BandeiraAmarelaTextView = findViewById<TextView>(R.id.BandeiraAmarela).apply {
            text = BandeiraAmarela
        }

       val btn = findViewById<Button>(R.id.novaconsulta)
        btn.setOnClickListener(){
            finish()
        }
    }

}