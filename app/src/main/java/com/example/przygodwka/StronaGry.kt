package com.example.przygodwka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_strona_gry.*

class StronaGry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strona_gry)

        val fabula = Fabula( this)

        wyborButton1.setOnClickListener{

            fabula.wyborPunktu(fabula.nastepnyPunkt1)
        }
        wyborButton2.setOnClickListener{

            fabula.wyborPunktu(fabula.nastepnyPunkt2)
        }
        wyborButton3.setOnClickListener{

            fabula.wyborPunktu(fabula.nastepnyPunkt3)
        }


        fabula.punktStartowy()


    }
    fun stronaStartowa(){
        val stronaS = Intent(this, MainActivity::class.java)
        startActivity(stronaS)
    }

}