package com.example.ex20221130

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ExamActivity : AppCompatActivity() {

    lateinit var clExam : ConstraintLayout

    override fun onRestart() {
        super.onRestart()
        val sharedPreferences = getSharedPreferences("sp1", Context.MODE_PRIVATE)
        val color = sharedPreferences.getString("bgColor", "white")
        clExam.setBackgroundColor(Color.parseColor(color))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)

        // 로그인 기능
        // 자동 로그인
        // Application 을 종료해도 정보가 저장될 필요성이 있다
        // DataBase (쿠키, 세션)
        // - RDB (Relational DataBase)
        // - RDBMS
        // -> OracleDB, MySQL, MariaDB
        // SQL    -> 쿼리문 작성
        // NoSQL  -> (Key, Value) ex)JSON, xml

        // SQLite -> 실제 데이터베이스 안드로이드 내장
        // SharedPreference -> 환경설정정보들을 공유하기 위해!!
        // NoSQL -> Key, Value
        // 버튼 -> 그리드 -> 리니어 -> 그리드

        val btnRed = findViewById<Button>(R.id.btnRed)
        val btnPink = findViewById<Button>(R.id.btnPink)
        val btnBlack = findViewById<Button>(R.id.btnBlack)
        val btnOther = findViewById<Button>(R.id.btnOther)

        clExam = findViewById<ConstraintLayout>(R.id.clExam)

        // tvResult : 변수
        // PI = 3.141592... : 상수
        // key, value
        val sharedPreferences = getSharedPreferences("sp1", Context.MODE_PRIVATE)

        // MODE_PRIVATE : 생성한 application 내에서만 공유 가능
        // MODE_WORLD_READABLE : 다른 application 에서 읽을 수 있음
        // MODE_WORLD_WRITEABLE : 다른 application 에서 읽고 쓸 수 있음

        // ? = as String
        val bgColor:String? = sharedPreferences.getString("bgColor", "white")
        clExam.setBackgroundColor(Color.parseColor(bgColor))

        btnRed.setOnClickListener {
            val editor = sharedPreferences.edit()
            val chColor:String = "#FF0000"
            editor.putString("bgColor", chColor)//red or FF0000
            editor.commit()
            clExam.setBackgroundColor(Color.parseColor(chColor))
        }
        btnPink.setOnClickListener {
            val editor = sharedPreferences.edit()
            val chColor:String = "#E91E63"
            editor.putString("bgColor", chColor)//red or FF0000
            editor.commit()
            clExam.setBackgroundColor(Color.parseColor(chColor))
        }
        btnBlack.setOnClickListener {
            val editor = sharedPreferences.edit()
            val chColor:String = "#000000"
            editor.putString("bgColor",chColor)
            editor.commit()
            clExam.setBackgroundColor(Color.parseColor(chColor))
        }

        btnOther.setOnClickListener {

            val intent = Intent(this, ColorActivity::class.java)
            startActivity(intent)
        }




    }
}