package com.example.ex20221129

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class BoardActivity : AppCompatActivity() {

    lateinit var tvContent: TextView
    lateinit var btnWrite: Button
    lateinit var btnBoard: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        btnWrite = findViewById<Button>(R.id.btnWrite)
        val btnLogin1 = findViewById<Button>(R.id.btnLogin1)
        tvContent = findViewById<TextView>(R.id.tvContent)
        val lv = findViewById<ListView>(R.id.lv)
        val etBoard = findViewById<EditText>(R.id.etBoard)
        btnBoard = findViewById<Button>(R.id.btnBoard)
        btnBoard.isEnabled = false

        // 1. 로그인 버튼을 누르면 LoginActivity 로 이동
        // (단, LoginActivity 에서 받아올 결과 값이 있음 : 양방향)

        btnLogin1.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            result.launch(intent)
        }

//        lv.setOnItemClickListener(object : OnItemClickListener {
//            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                if (p0 != null) {
//                    Toast.makeText(
//                        this@BoardActivity,
//                        p0.adapter.getItem(p2).toString(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        })

        // adapterView : ListView 에 대한 정보
        // view : ListView 가 있는 현재 페이지에 대한 정보
        // i (position) -> 내가 클릭한 item 위치 (index 0~
        // l (id) : long -> 내가 클릭한 item 의 고유한 값
        lv.setOnItemClickListener { p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long ->
            if (p0 != null) {
                Toast.makeText(
                    this@BoardActivity,
                    p0.adapter.getItem(p2).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // onCreate()안쪽에

        // Adapter View 를 사용하기 위한 6단계

        // 1. Container 결정
        // -> ListView 의 위치를 결정!!
        // val lv = findViewById<ListView>(R.id.lv) 초기화

        // 2. Template 결정
        // -> 각 항목(Item)에 적용될 디자인을 결정!!
        // -> layout 패키지에 xml 형태로 생성!!
        // board_list.xml 최상위 레이아웃 : TextView
        // 이 때, id는 tvBoard

        // 3. Item 결정
        // VO
        val data = ArrayList<String>()
        data.add("1. 오늘 점심 구미구미")
        data.add("2. 돈가스집")
        data.add("3. 로스카츠 먹음")

        // 4. Adapter 결정
        // Adapter : 디자인(항목 뷰, 템플릿) + Item 결합해서
        // AdapterView 에 동적으로 뿌려주는 역할!!

        // ArrayAdapter 를 사용하자
        // 조건) 템플릿이 TextView, 아이템 요소가 String
        // 생성자의 요소 4개
        // 1) 페이지 정보
        // 2) 템플릿(항목 뷰)
        // 3) TextView 의 id
        // 4) Item
        val adapter = ArrayAdapter<String>(this, R.layout.board_list, R.id.tvBoard, data)

        // 5. Container 에 Adapter 부착
        lv.adapter = adapter

        // 6. Event 처리

        // 1) btnBoard 를 클릭했을 때,
        btnBoard.setOnClickListener {
            // 2) etBoard 의 값을 가져와서
            // 3) val input 에 저장
            val input = etBoard.text.toString()
            // 4) data 에 input 을 추가!!
            data.add(input)

            // adapter 를 새로고침하자!!
            adapter.notifyDataSetChanged()
            etBoard.text = null
        }

        lv.setOnItemClickListener { adapterView, view, i, l ->

            // AlertDialog 옵션 정보를 담는 builder 생성!

            val builder = AlertDialog.Builder(this)
            builder.setTitle("게시글 삭제")
            builder.setMessage("정말 삭제하시겠습니까?")
            builder.setPositiveButton("삭제"
            ) { _, _ ->
                data.removeAt(i)
                adapter.notifyDataSetChanged()
            }
//            builder.setPositiveButton("삭제",
//                DialogInterface.OnClickListener { dialogInterface, id ->
//                    data.removeAt(i)
//                    adapter.notifyDataSetChanged()
//                }
//            )


            builder.setNegativeButton("취소", null)

            // 주의
            // builder 를 통해 옵션을 단 이후
            // 맨 마지막에는 무조건!! show() 함수를 달아야 한다

            builder.show()

        }

        // AdapterView 만드는 법
        // 1. Container 결정 -> ListView 의 위치 결정
        // 2. Template 결정 -> 항목 뷰 결정!! (디자인)
        // 3. Item 결정 -> ArrayList<String>
        // 4. Adapter 결정 -> ArrayAdapter
        // 5. Container 에 Adapter 부착
        // 6. Event 처리


    }

    // intent 데이터 받아주는 콜백함수 생성
    val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            tvContent.text = "로그인 성공"
            // btnWrite 활성화
            btnWrite.isEnabled = true
            btnBoard.isEnabled = true
            Toast.makeText(this, "로그인성공", Toast.LENGTH_SHORT).show()
        } else {
            // tvContent 에 로그인 실패
            tvContent.text = "로그인 실패"
        }
    }

    // C:\Users\smhrd\AndroidStudioProjects 안드로이드 프로젝트
    // 알집 압축 -> 옮기기 -> 압축해제 -> Welcome to ~ - Open 파일탐색기 - 경로체크 -> 프로젝트 폴더 열기~!
    // * sdk 경로 다를 수 있음. - 패치 완료 후 - And studio 껏다 다시 키기

}