package com.example.ex20221128

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ListView

class FirstActivity : AppCompatActivity() {

    var color : String = "white" // 배경 색상을 저장해 Second Activity 로 보내자!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btnNext = findViewById<Button>(R.id.btnNext)

        val lv = findViewById<ListView>(R.id.lv)

        // inner class
        // 익명 클래스 anonymous class
//        btnNext.setOnClickListener(object:View.OnClickListener{
//            override fun onClick(p0: View?) {
//
//            }
//        })

        lv.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {


                // p0 null 체크
                if(p0 != null){
                    color = p0.adapter.getItem(p2).toString()
                }

                // p2 : position
//                if(p2 ==0){
//                    color = "purple"
//                }else if(p2 == 1){
//                    color = "yellow"
//                }else if(p2 == 2){
//                    color = "pink"
//                }

                Log.d("찍어보자", color)
            }
        })

        // 버튼 클릭을 감지하는 리스너

        // btnNext 를 클릭했을 때, SecondActivity 로 이동!
//        btnNext.setOnClickListener {
//            // Activity 로 이동하는 Intent (명시적 인텐트)
//            // (시작Activity, 도착Activity)
//            // (this, java class)
//            // kclass로 만들어진 Activity 를 java class 로 바꿔줘야한다.
//            // 액티비티명 ::class.java ---> java class 로 바뀜
//            var intent = Intent(this, SecondActivity::class.java)
//
//            // 실행!!!!
//            startActivity(intent)
//        }

        // btnNext 를 누르면 SecondActivity 로 color 코드를 가지고 넘어간다
        btnNext.setOnClickListener {
            var intent = Intent(this@FirstActivity, SecondActivity::class.java)
            //finish()// stack 구조에서 out 시키기
        // 키 값 변수명과 동일하게
        intent.putExtra("color",color)

        // 단방향 호출
            startActivity(intent) // stack 에 Activity 를 넣는다
        }


    }

    // overriding Ctrl + o or 마우스 우클릭 -> generate -> override methods
    override fun onStart() {
        super.onStart()
        Log.d("생명주기", "onStart입니다.")

    }

    override fun onStop() {
        super.onStop()
        Log.d("생명주기", "onStop입니다.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("생명주기", "onResume입니다.")
    }

    override fun onPause() {
        super.onPause()
        Log.d("생명주기", "onPause입니다.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("생명주기", "onRestart입니다.")
    }
}