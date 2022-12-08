package com.example.ex20221128

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    var loginId: String? = null
    var loginPw: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. 3개의 component 초기화!!

        val etId = findViewById<EditText>(R.id.etId)
        val etPw = findViewById<EditText>(R.id.etPw)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // 2. btnLogin 을 클릭했을 때, etId와 etPw에 담긴 문자열을
        // 각각, loginId와 loginPw에 저장!!
        btnLogin.setOnClickListener {
            loginId = etId.text.toString()
            loginPw = etPw.text.toString()

            // 3. DB Activity 로 이동하기 위한
            // intent 를 만들자!!
            val intent = Intent(this, DBActivity::class.java)
            
            // 4. intent 안에 정보를 넣자
            intent.putExtra("loginId", loginId)
            intent.putExtra("loginPw", loginPw)

            startActivity(intent)
        }

    }
}