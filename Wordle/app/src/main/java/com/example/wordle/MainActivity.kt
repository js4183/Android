package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answer = "apple"

        // Adapter View 사용 6단계
        // ListView, RecyclerView,
        // RecyclerView 사용 6단계
        // 1. Container 결정
        val rvWordle = findViewById<RecyclerView>(R.id.rvWordle)

        // 2. Template 결정
        // game_list.xml

        // 3. Item 결정
        val wordleList = ArrayList<WordleVO>()
        wordleList.add(WordleVO("","","","",""))
        wordleList.add(WordleVO("","","","",""))
        wordleList.add(WordleVO("","","","",""))
        wordleList.add(WordleVO("","","","",""))
        wordleList.add(WordleVO("","","","",""))
        wordleList.add(WordleVO("","","","",""))

        // 4. Adapter 결정
        // GameAdapter
        val adapter = WordleAdapter(this, wordleList, answer)

        // 5. Container 에 Adapter 부착
        rvWordle.adapter = adapter
        rvWordle.layoutManager = LinearLayoutManager(this)
    }
}