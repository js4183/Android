package com.example.ex20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ImageActivity : AppCompatActivity() {

    // 배열 이름
    val imgArray = intArrayOf(R.drawable.pink, R.drawable.black, R.drawable.blue, R.drawable.yellow, R.drawable.red)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // View 의 id값 다 찾아오기
        val img = findViewById<ImageView>(R.id.img)
        val btnPre = findViewById<Button>(R.id.btnPre)
        val btnNext = findViewById<Button>(R.id.btnNext)
        
        // 이미지 값 바꾸기
        img.setImageResource(R.drawable.pink)

        var index = 0

        btnPre.setOnClickListener {
            index--
            // if (index < 0) index = imgArray.size - 1
            if(index<0){
                index = 4
            }
            img.setImageResource(imgArray[index])
        }

        btnNext.setOnClickListener {
            index ++
            // if (index > imgArray.size - 1) index = 0
            if(index>4){
                index=0
            }
            img.setImageResource(imgArray[index])
        }


        // Pre 버튼을 눌렀을 때! (setOnClickListener)
        // 1-1. index -1 감소
        // 해당 index 에 있는 img 의 id를 가져와서
        // ImageView 에 set 하자!
        // index 의 조건 : 0 보다 작으면 다시 index 값을 size-1으로 돌리자

        // 2. Next 버튼을 눌렀을 때
        // 2-1 index +1 증가
        // 해당 index 에 있는 img 의 id를 가져와서
        // ImageView 를 set 하자
        // index 의 조건 : size -1보다 크면 다시 index 값을 0으로


    }
}