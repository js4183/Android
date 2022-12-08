package com.example.ex20221129

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View id 값 찾아오기
        tvResult = findViewById<TextView>(R.id.tvResult)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // btnNext 를 눌렀을 때
        btnNext.setOnClickListener {
            // Intent 생성
            // k-class -> java class 로 변환
            val intent = Intent(this, SubActivity::class.java)
            // Intent 실행 ( SubActivity 이동 및 요청)
            // startActivityForResult(intent, 1004)
            // requestCode : 결과값을 보내 줘야하는 Activity 를 구분하기 위한 코드
            // 코드 줄 표시 : 버전 업데이트 시 없어질 수도 있는 코드를 의미
            launcher.launch(intent)
            // 실행하려면 launch() 키워드가 붙어줘야함 전달이자가 내가 생성한 intent 넣어주기
        }
    }// onCreate 밖

    // Intent 통해서 받아온 결과값을 처리할 수 이도록 도와주는 함수
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        // 1) requestCode : (1004) 내가 보낸 요청코드를 받아오는 매개변수
//        // 2) resultCode : RESULT_OK 받아온 결과값의 상태
//        // 3) Intent? data : str(문구)가 붙어있는 Intent 를 받아오는 매개변수
//
//        // 내가 보냈던 요청이 맞는지 == 요청코드가 1004가 맞는지 판단
//        if (requestCode == 1004) {
//            // resultCode 도 내가 원하는 결과값이 맞는지 (RESULT_OK가 맞는지?)
//            if (resultCode == RESULT_OK) {
//                // 두 가지다 만족하면 받아온 결과값을 처리 하겠습니다
//                // tvResult 의 text 를 받아온 str 로 바꾸기
//                // 1. str 꺼내기
//                val str = data?.getStringExtra("str")
//                // 2. TextView 내용을 str 로 바꾸기
//                tvResult.text = str
//            }
//        }
//    }

    // callback 함수
    // 1. 다른 함수의 인자로 사용되는 함수
    // 2. 어떤 이벤트에 의해 호출되어지는 함수
    // -> 버튼클릭하면 Intent 실행 호출

    // ActivityResultLauncher
    // : 액티비티에서 데이터를 받아오기 위해 사용하는 함수
    // : Fragment(부분화면)에서도 데이터를 주고받을 때 사용할 수 있음
    // 기존에 ActivityForResult 는 메모리가 너무 작음 -> 프로세스, 액티비티
    // 소멸될 수 있다
    // 런처는 메모리부족으로 소멸되었다가 재생성해도 결과값을 받아온다
    
    // Contract 자료형, 콜백메서드
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        // 실제 ActivityResultContracts 안
        // 1) createIntent --> StartActivityForResult 대체
        // 2) parseResul --> onActivityResult 대체 (resultCode 랑 Intent 만 받아온다)
        // 런처를 사용하게 되면 요청을 보낸 Activity 를 구분할 필요가 없다
        // requestCode 가 필요없습니다!

        // it 에서 resultCode 랑 data 를 추출
        Log.d("data",it.data.toString())
        Log.d("data",it.resultCode.toString())
        
        // resultCode 가 RESULT_OK 인지 확인
        if (it.resultCode == RESULT_OK){
            tvResult.text = it.data?.getStringExtra("str")

        }
    }


}