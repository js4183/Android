package com.example.ex20221130

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var phoneList = ArrayList<PhoneVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv = findViewById<ListView>(R.id.lv)

        // 1. 화면에서 ListView의 위치 정해주기 (xml 파일) v

        // 2. ListView 한 칸에 들어갈 디자인 정해주기 (xml 파일) v

        // 3. ListView에 들어갈 데이터 만들기 -> 하나의 자료형 (PhoneVO) v
        // 이미지뷰에 들어갈 Image의 ID값 (Int)
        // 이름, 전화번호 (String)
        val p1 = PhoneVO(R.drawable.img1, "임보미", "010-1234-5678")
        val p2 = PhoneVO(R.drawable.img2, "박병관", "010-2564-7894")
        val p3 = PhoneVO(R.drawable.img3, "최태양","010-5623-8956")
        val p4 = PhoneVO(R.drawable.img4,"조자연","010-7895-1234")
        val p5 = PhoneVO(R.drawable.img5, "강예진","010-7895-4567")

        phoneList.add(p1)
        // phoneList.add(PhoneVO(R.drawable.img2, "박병관", "010-2564-7894"))
        phoneList.add(p2)
        phoneList.add(p3)
        phoneList.add(p4)
        phoneList.add(p5)

        // 4. Adapter 만들기
        // 데이터의 자료형이 내가만든 자료형(VO)이기 때문에
        // 안드로이드에서 기본적으로 제공하는 ArrayAdapter는 사용이 불가능
        // Adatper : 데이터랑 템플릿을 합쳐서 ListView에 적재시켜주는 역할
        val adapter = PhoneAdapter(applicationContext, R.layout.phone_list, phoneList)
        // 5. ListView에 Adapter 적용
        lv.adapter = adapter
        // 6. 이벤트 달아주기기


    }
}