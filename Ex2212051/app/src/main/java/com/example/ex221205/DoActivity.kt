package com.example.ex221205

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class DoActivity : AppCompatActivity() {

    var isPlaying: Boolean = true
    var score: Int = 0 // 점수를 저장하는 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_do)

        val tvScore = findViewById<TextView>(R.id.tvScore)
        val tvTime = findViewById<TextView>(R.id.tvTime)
        val btnStart = findViewById<Button>(R.id.btnStart)

        val imgViews = ArrayList<ImageView>()

        for (i in 1..9) {
            val resId = resources.getIdentifier("imageView$i", "id", packageName)
            val imgView = findViewById<ImageView>(resId)
            imgViews.add(imgView)
            // 초기화 잘되었는지 확인방법!
            imgView.visibility = View.INVISIBLE
        }

        btnStart.setOnClickListener {
            isPlaying = true
            val thread2 = TimeThread(tvTime)
            thread2.start()

            for (i in 0 until imgViews.size) {
                val imgView = imgViews.get(i)
                imgView.visibility = View.VISIBLE
                // arg1, 2 Int 타입이므로
                // 각 이미지뷰의 tag 는 최초 0이다 0은 두더지가 앉아 있음을 의미
                imgView.tag = 0

                val thread = DoThread(imgView)
                thread.start()

                imgView.setOnClickListener {

                    if (imgView.tag == 1) {
                        score++
                    } else {
                        if (score > 0) {
                            score--
                        }
                    }
                    tvScore.setText("현재점수 : $score")
                    imgView.setImageResource(R.drawable.off)
                }
            }


        }


    } // onCreate() 끝

    // Looper 명시해주는게 좋음
    val handler2 = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val time = msg.arg1
            val tv = msg.obj as TextView
            tv.setText(time.toString())
        }
    }

    inner class TimeThread(val tv: TextView) : Thread() {
        override fun run() {
            super.run()

            for (i in 30 downTo 0) {
                val message = Message()
                message.arg1 = i
                message.obj = tv
                handler2.sendMessage(message)
                Thread.sleep(1000)
            }
            isPlaying = false
            // val intent = Intent(this@DoActivity, MainActivity::class.java)
            // startActivity(intent)
        }
    }

    val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val imgView = msg.obj as ImageView // 어떤 이미지 뷰에 적용될 건지 ??
            val img = msg.arg1 // on 이미지인지 off 이미지인지 (이미지 정보를 담고 있는 리소스)
            val tag = msg.arg2 // 현재이미지의 상태 0 앉아있는지 1 일어나있는지
            imgView.setImageResource(img)
            imgView.tag = tag
        }
    }
//    val offHandler = object : Handler(Looper.getMainLooper()) {
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//            val imgView = msg.obj as ImageView
//            imgView.setImageResource(R.drawable.off)
//        }
//    }

    inner class DoThread(val imgView: ImageView) : Thread() {
        override fun run() {
            super.run()

            while (isPlaying) {
                var level = score * 20
                if (score >= 40) {
                    level = 800
                }
                // 랜덤하게 0 ~ 5초후에 일어나게!!
                val onTime = Random.nextInt(5 * (1000 - level))
                Thread.sleep(onTime.toLong())
                val message = Message()
                message.arg1 = R.drawable.on // R.drawable 데이터 타입 Int
                message.arg2 = 1 // 1은 일어남을 의미지
                message.obj = imgView
                handler.sendMessage(message)

                val offTime = Random.nextInt(1 * (1000 - level)) + 200
                Thread.sleep(offTime.toLong())
                val message2 = Message()
                message2.arg1 = R.drawable.off
                message2.arg2 = 0 // 0은 앉아있음을 의미
                message2.obj = imgView
                handler.sendMessage(message2)

                Thread.sleep(1000)
            }
        }

    }

}