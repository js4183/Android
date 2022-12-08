package com.example.ex20221129

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        // MainActivity 에서 requestCode 와 함께 Intent 로 이동 한 상태

        val etResult = findViewById<EditText>(R.id.etResult)
        val btnSend = findViewById<Button>(R.id.btnSend)

        // btnSend 를 눌렀을 때!
        btnSend.setOnClickListener {
            // 1. EditText 에 적혀있는 문구를 가져온다
            // 2. 문구를 변수에 저장한다
            val str = etResult.text.toString()
            // 3. Intent 생성한다
            val intent = Intent()
            // 4. Intent 에 데이터(문구)를 붙혀준다 --> putExtra
            intent.putExtra("str", str)
            // 5. setResult(resultCode, intent)
            setResult(RESULT_OK, intent)
            // resultCode : 결과값의 상태를 Main 에서 판단하기위한 신호(코드)
            // 6. finish()
            finish()
        }

    }
}