package com.example.ex20221129

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

        val etId = findViewById<EditText>(R.id.etId)
        val etPw = findViewById<EditText>(R.id.etPw)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            // EditText 에 적혀있는 내용을 가져온다 (변수에 저장)
            loginId = etId.text.toString()
            loginPw = etPw.text.toString()
            val intent = Intent()
            if (loginId == "test" && loginPw == "1234") {
                setResult(RESULT_OK, intent)
            } else {
                setResult(RESULT_CANCELED, intent)
            }
            finish()
        }
        // setResult(resultCode, intent)
    }
}