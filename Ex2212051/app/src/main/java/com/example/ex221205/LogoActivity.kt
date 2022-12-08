package com.example.ex221205

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        Handler().postDelayed({
            // Intent 생성
            val intent = Intent(this@LogoActivity,DoActivity::class.java)
            // Intent 실행
            startActivity(intent)

        },3000)
    }
}