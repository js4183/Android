package com.example.ex20221124

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. View 들의 id 값을 찾아오자 (findViewById)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPw = findViewById<EditText>(R.id.etPw)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // 2. Button 에 Event 달아주기 (setOnClickListener)
        btnLogin.setOnClickListener {

            // 2-1. EditText 에 적혀있는 email, password 값을 가져오기
            // (email, pw : 변수)---> 문자열로 형변환
            var email = etEmail.text.toString()
            var pw = etPw.text.toString()

            // 2-2. 가져온 email, pw가 smhrd@smhrd.or.kr, qwer1234 가 맞는지 판단 (조건식)
            if(email == "smhrd@smhrd.or.kr" && pw=="qwer1234"){
                // 맞다면 Toast로 "로그인 성공"
                Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
            }
            else{
                // 틀리면 Toast로 "로그인 실패"를 띄워주세요!!!
                Toast.makeText(this,"로그인실패",Toast.LENGTH_SHORT).show()
            }
        }
    }
}