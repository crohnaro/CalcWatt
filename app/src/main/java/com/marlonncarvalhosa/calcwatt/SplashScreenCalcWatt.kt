package com.marlonncarvalhosa.calcwatt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashScreenCalcWatt : AppCompatActivity() {
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this,CalculoAcitivity::class.java)
            startActivity(intent)
        }, 3000)

        val url = "https://res.cloudinary.com/dxcxlukk1/image/upload/v1651057312/logo1_rt3nkj.png"
        val iv = findViewById<ImageView>(R.id.logo_1)
        Glide.with(this).load(url).into(iv)


    }
}