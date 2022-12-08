package com.example.ex20221129

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import java.util.Random

class LunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)

        // Adapter View 만드는 6단계

        // 1. Container 결정 (위치 결정)
        val lvLunch = findViewById<ListView>(R.id.lvLunch)
        val etLunch = findViewById<EditText>(R.id.etLaunch)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnLunch = findViewById<Button>(R.id.btnLunch)
        val tvLunch = findViewById<TextView>(R.id.tvLaunch)
        // viewBinding 기법 -> 초기화를 해결

        // 2. Template 결정 (아이템 디자인)
        // Lunch_list.xml (res -> layout -> new -> Layout Resource file 로 작성)

        // 3. Item 결정 (만약, 자료형이 여러개라면 VO Class 생성!)
        val data = ArrayList<String>()
        data.add("돈까스")
        data.add("제육볶음")

        // 4. Adapter 결정
        // (만약, TextView 와 ArrayList<String> 사용한다면 ArrayAdapter 사용가능)
        // 1) 페이지 정보
        // 2) 항목 뷰 디자인
        // 3) TextView 의 id
        // 4) data
        val adapter = ArrayAdapter<String>(
            this,
            R.layout.lunch_list,
            R.id.tvMenu,
            data
        )

        // 5. Container 에 Adapter 부착
        lvLunch.adapter = adapter

        // 6. Event 처리
        // 1) btnAdd 를 눌렀을 때, etAdd 의 값을 가져와서
        // 2) data 에 추가!!
        // 3) adapter 새로고침

        // btnAdd.text = "추가"
        // btnAdd.setTextSize(20F)

        btnAdd.setOnClickListener {
            data.add(etLunch.text.toString())
            etLunch.text = null
            adapter.notifyDataSetChanged()
        }

        btnLunch.setOnClickListener {
            var rd = Random()
            val menu = rd.nextInt(data.size)
            // tvLunch.text = data.get(menu)
            tvLunch.text = data[menu]
        }


    }
}