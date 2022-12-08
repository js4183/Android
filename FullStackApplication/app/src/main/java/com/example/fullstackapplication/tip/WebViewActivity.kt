package com.example.fullstackapplication.tip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.fullstackapplication.R

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // 받아온 Url 값을 내서
        // 해당 웹페이지가 WebView 에 뜨게 만들자
        // Fragment 1202

        val wv = findViewById<WebView>(R.id.wv)
        // String? 타입으로 받아옴
        val address = intent.getStringExtra("url")

        // WebView Setting
        // WebView 에 원하는 웹페이지 띄우기
        // 1. 주소준비

        // 2. 설정변경 ( JavaScript 지원 )
        val ws =wv.settings
        ws.javaScriptEnabled = true

        // 3. WebView 에 Client 설정!
        wv.webViewClient = WebViewClient()

        // 4. 주소 적용
        // intent 로 부터 값을 무조건 받아오는 이유
        // 값이 없으면 RecyclerView 에서 안보임 (실행이 안됨)
        wv.loadUrl(address!!)


    }
}