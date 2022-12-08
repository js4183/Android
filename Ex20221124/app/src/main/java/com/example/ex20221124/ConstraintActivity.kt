package com.example.ex20221124

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// : Kotlin 에서 상속
class ConstraintActivity : AppCompatActivity() {

    // 전역변수(뷰) 선언
    lateinit var tvResult: TextView
    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    // 뷰에 대해서는 선언만 하는 거는 불가능 초기화가 꼭 이루어져야한다.
    // 그런데 lateinit이라는 키워드로 나중에 꼭 초기화를 하겠다
    // 라는 약속을 할 수 있다!

    // onCreate()는 Activity 가 실행될때 최초 딱 한번(가장 먼저) 호출되는 메서드
    // : Activity 생명주기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ***** xml 이랑 kotlin class 랑 연결하는 코드 없으면 화면 안뜸 *****
        setContentView(R.layout.activity_constraint)

        // 1. xml 의 View 에 id를 지정
        // 2. id 값을 이용해서 view 를 찾아온다. (findViewById)
        // R : 리소스(폴더).id.tvResult
        tvResult = findViewById(R.id.tvResult)
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        // val tvResult:TextView = findViewById<TextView>(R.id.tvResult) 추론이 가능
        // id 값은 문자열로 정해줬는데 받아오는값이 Int
        // R 폴더에 모든 뷰(리소스)들의 id 값이 저장이 되는데 주소값이 저장
        // 16진수 상수형태로 저장이 되어있다 (Int)

        // ** setContentView 위로 find 할 수 없다!! **
        tvResult.setTextColor(Color.BLUE)
        tvResult.setTextColor(Color.parseColor("#ff9999"))
        // textSize 에는 Float 자료형이 들어가야 함. (f : 형변환)
        tvResult.textSize = 40.0f
        tvResult.text = "안녕하세요!"
        // charSequence 인터페이스 - String 은 CharSequence 인터페이스 상속 받는 중

        // - 더하기 버튼을 눌렀을 때 "더하기 버튼이 눌렸습니다." 라는
        // Toast 를 띄우기!
        // 이벤트를 주는 방법
        // 1) 이벤트 메소드 설계 후 뷰에 연결하기
        // 2) innerClass (Listener OnClick 구현)



        btnPlus.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1+num2
            tvResult.text = "연산결과 : $res"
            //Toast.makeText(this, "연산결과 : $res",Toast.LENGTH_SHORT).show()
        }
        btnMinus.setOnClickListener {
            // {}안에다가 기능 구현만 하면됨!! *(v->V)
            // 버튼을 눌렀을 때 "마이너스 버튼이 눌렸습니다" 토스트 띄우기
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()

            var res = num1-num2
            tvResult.text = "연산결과 : $res"
            //Toast.makeText(this, "연산결과 : $res", Toast.LENGTH_SHORT).show()

            // 1. EditText 에 적혀있는 숫자
            // etNum1, etNum2 에 있는 내용 변수 num1, num2 에 저장
            // 실제로 getText --> Editable ---> 문자열로 형변환 ---> 정수형
            // 2. num1, num2 연산 결과를 문자열로 바꿔서 set 해주세요!
            //  -1. num1, num2 연산 결과를 tvResult 에 set 해주세요!
        }
        btnMul.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1*num2
            tvResult.text = "연산결과 : $res"
            //Toast.makeText(this, "연산결과 : $res", Toast.LENGTH_SHORT).show()
        }
        btnDiv.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1/num2
            tvResult.text = "연산결과 : $res"
            //Toast.makeText(this, "연산결과 : $res", Toast.LENGTH_SHORT).show()
        }



        // 3) interface 를 상속받게 만들어서 OnClick 구현



    }// onCreate 밖

    // 이벤트 리스너는 무조건 View 매개변수를 가지고 있어야한다.
    fun myClick(view: View){
        // Toast 띄우기!
        // 1) this, ConstraintActivity.this : Toast 를 띄울 화면 정보
        // 2) 문구 (무조건 String, Int 가 허용되는 경우는 id 값만)
        // 3) Toast 에 short(3초), Long(5초) 속성 사용
         Toast.makeText(this,"더하기 버튼이 눌렸습니다.",Toast.LENGTH_SHORT).show()
        //editable -> 문자열 변환 -> 정수형으로 변환
        var num1 = etNum1.text.toString().toInt()
        var num2 = etNum2.text.toString().toInt()
        // Emulator 를 처음실행시키면 EditText 에는 아무 값도 없음 ""
        // "".toInt() NumberFormatException
        // 버튼을 눌렀을 때 적혀있는 값을 가지고 와줘야 함!!!
        var result = num1 + num2
        //tvResult.text = "연산 결과 : $result"
        //tvResult.text = result.toString()
    }



}