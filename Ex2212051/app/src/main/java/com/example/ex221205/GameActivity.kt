package com.example.ex221205

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    var time: Int = 0 // 시간 기록 변수
    var timeTop: Int = 0
    lateinit var tv1To25Time: TextView
    lateinit var tv1To25Timer: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val btnGame = findViewById<Button>(R.id.btnGame)
        val numbers = ArrayList<Int>()
        tv1To25Time = findViewById<TextView>(R.id.tv1To25Time)
        tv1To25Timer = findViewById<TextView>(R.id.tv1To25Timer)
        var cnt = 1 // 현재 눌러야 되는 숫자

        for (i in 1..25) {
            numbers.add(i)
        }

//        for (i in 0 until 100) {
//            val rdNum1 = Random.nextInt(25) // 0~25
//            val rdNum2 = Random.nextInt(25) // 0~25
//
//            // 치환 예) rdNum1 = 3, rdNum2 = 6
//            val temp = numbers.get(rdNum1)
//            numbers[rdNum1] = numbers[rdNum2]
//            numbers[rdNum2] = temp
//        }

        // Log.d("랜덤", numbers.toString())

        val btns = ArrayList<Button>()

        for (i in 1..25) {
            val resId = resources.getIdentifier("btn$i", "id", packageName)
            val btn = findViewById<Button>(resId)
            btns.add(btn)
            btn.visibility = View.INVISIBLE
        }

        btnGame.setOnClickListener {
            btns.shuffle()
            cnt = 1
            for (i in 0 until btns.size) {
                val btn = btns.get(i)
                btnSet(btn, numbers.get(i))


                btn.setOnClickListener {
                    if (btn.text.toString().toInt() == cnt) {
                        btn.visibility = View.INVISIBLE
                        cnt++

                    }
                }

            }
        }

    }

    fun btnSet(btn: Button, value: Int) {
        btn.setText(value.toString())
        btn.visibility = View.VISIBLE
    }

    fun rdSet(numbers: ArrayList<Int>, cnt: Int) {

    }

    val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val time = msg.arg1
            val tv = msg.obj as TextView
            tv.setText(time.toString())
        }
    }

    fun start() {
        time = 0
        tv1To25Time.text = "00 : 00"
        timerTask = timer(period = 10) {
            var sec = (time / 100).toString()
            var milli = (time % 100).toString()

            if (sec.toInt() < 10) sec = "0$sec"
            if (milli.toInt() < 10) milli = "0$milli"

            runOnUiThread {
                tv1To25Time.text = "$sec : $milli"
            }
        }
    }

    fun stop() {
        if (timeTop > time) {
            timeTop = time
            var sec = (time / 100).toString()
            var milli = (time % 100).toString()
            if (sec.toInt() < 10) sec = "0$sec"
            if (milli.toInt() <10) milli = "0$milli"
            tv1To25Time.text = "$sec : $milli"
        }


    }
}