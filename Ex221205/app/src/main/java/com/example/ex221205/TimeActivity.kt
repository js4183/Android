package com.example.ex221205

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.timer

class TimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val tvMin = findViewById<TextView>(R.id.tvMin)
        val tvSec = findViewById<TextView>(R.id.tvSec)
        val tvMilSec = findViewById<TextView>(R.id.tvMilSec)
        val btnR = findViewById<Button>(R.id.btnR)
        val btnS = findViewById<Button>(R.id.btnS)
        val btnP = findViewById<Button>(R.id.btnP)

        btnS.setOnClickListener {


        }


    }
}