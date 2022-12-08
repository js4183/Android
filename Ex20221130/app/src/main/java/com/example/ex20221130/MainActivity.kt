package com.example.ex20221130

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // - RecyclerView
        // AdapterView 만드는 6단계
        // 1) Container 결정
        val lvPoke = findViewById<ListView>(R.id.lvPoke)

        // 2) Template 결정
        // poke_list.xml

        // 3) Item 결정
        // PokeVO class 생성!!
        val pokeList = ArrayList<PokeVO>()
        pokeList.add(PokeVO(R.drawable.p1, "피카츄", "전기"))
        pokeList.add(PokeVO(R.drawable.p2, "꼬부기", "물"))
        pokeList.add(PokeVO(R.drawable.p3, "파이리", "불"))
        pokeList.add(PokeVO(R.drawable.p4, "이상해씨", "풀"))
        pokeList.add(PokeVO(R.drawable.p5, "버터플", "벌레"))
        pokeList.add(PokeVO(R.drawable.p6, "구구", "비행"))

        // 4) Adapter 결정
        // PokeAdapter 생성!!
        // ArrayAdapter (페이지 정보, 템플릿, TV id, data)
        val adapter = PokeAdapter(this@MainActivity, pokeList)

        // 5) Container에 Adapter 부착
        lvPoke.adapter = adapter

        // 6) Event 처리
    }

    // inner Class 사용하는 이유?
    // 1. 부모 클래스의 변수들을 다 사용할 수 있다!!
    // 2. 외부에서 이 inner Class를 사용할 이유가 없을 때!!

    // Design Pattern - MVC
    // ViewHolder Pattern
    // getView 의 findViewById로 접근한 정보들을
    // 저장하고 있는 class ViewHolder 를 만들어서
    // 메모리의 성능을 향상시키자!!

    class ViewHolder() {
        var imgPoke: ImageView? = null
        var tvPokeLevel: TextView? = null
        var tvPokeName: TextView? = null
        var tvPokeType: TextView? = null
    }
}