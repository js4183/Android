package com.example.ex20221202

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class Fragment4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // id값 찾아오기
        val view = inflater.inflate(R.layout.fragment_4, container, false)
        val etUrl = view.findViewById<EditText>(R.id.etUrl)
        val btnSend = view.findViewById<Button>(R.id.btnSend)

        // 버튼을 클릭했을 때 일어나야하는 일!!!
        btnSend.setOnClickListener {
            // SharedPreference 에 Url 값 저장하기
             val url = etUrl.text.toString()
            // 1. SharedPreference 가져오기
            val spf = requireActivity().getSharedPreferences(
                "mySPF",
                Context.MODE_PRIVATE
            )
            // 2. SharedPreference 에 데이터를 저장할 수 있는 editor 가져오기
            val editor = spf.edit()

            // 3. editor 를 통해서 데이터 저장하기(commit)
            editor.putString("url", url).commit()
            // + Fragment1 에서 꺼내서 url 에 설정

        }


        // 1) 이름 지정
        // 2) 모드 설정
        // requireActivity.getSharedPreference()

        // 2. SharedPreference 에 데이터를 저장할 수 있는 editor 가져오기

        // 3. editor 를 통해서 데이터 저장하기 (commit)

        // + Fragment1 에서 꺼내서 url 에 설정


        return view
    }
}