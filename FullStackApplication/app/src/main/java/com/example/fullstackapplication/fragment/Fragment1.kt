package com.example.fullstackapplication.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fullstackapplication.ContactVO
import com.example.fullstackapplication.R
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val tvMsg = view.findViewById<TextView>(R.id.tvMsg)
        val clHome = view.findViewById<ConstraintLayout>(R.id.clHome)

        val etName = view.findViewById<EditText>(R.id.etName)
        val btnSend = view.findViewById<Button>(R.id.btnSend)

        val etContactName = view.findViewById<EditText>(R.id.etContactName)
        val etContactAge = view.findViewById<EditText>(R.id.etContactAge)
        val etContactTel = view.findViewById<EditText>(R.id.etContactTel)
        val btnContact = view.findViewById<Button>(R.id.btnContact)

        // val yehoUrl = "https://iotchat-188fe-default-rtdb.firebaseio.com/" // 예호쌤
        val yehoUrl = "https://full-stack-de685-default-rtdb.firebaseio.com/" // 내꺼
        val yehoDb = Firebase.database(yehoUrl)
        val jsm = yehoDb.getReference("주상민")
        // val msgC = yehoDb.getReference("msgC")

        btnSend.setOnClickListener{
            //val name = "주상민"
            val input = etName.text.toString()
            jsm.setValue(input)
            // msgC.push().setValue(MsgVO(name,input))
            etName.setText("")
        }

        // firebase 에서 데이터를 실시간으로 읽고 / 쓸 수 있는
        // RealTime DataBase
        // NoSQL 형식 - Key : Value (ex age : 21, color : black ...) value Json 형식 사용 가능

        // Write a message to the database
        // val database = Firebase.database // 연결된 firebase 계정의 RealTime DB를 연결
        val url = "https://full-stack-de685-default-rtdb.firebaseio.com/"
        val db = Firebase.database(url)
        val myRef = db.getReference("message")

        val color = db.getReference("color")

        val contact = db.getReference("contact2")

        btnContact.setOnClickListener{
            val name = etContactName.text.toString()
            val age = etContactAge.text.toString().toInt()
            val tel = etContactTel.text.toString()

            contact.push().setValue(ContactVO(name, age, tel))
        }

        color.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val bgColor = snapshot.getValue<String>()
                if (bgColor != null) {
                    // 제대로 입력했을 경우
                    try {
                        clHome.setBackgroundColor(Color.parseColor(bgColor))
                    } catch (e: IllegalArgumentException) {
                        // 오타났을경우
                        clHome.setBackgroundColor(Color.parseColor("yellow"))
                    } catch (e: StringIndexOutOfBoundsException){
                        // 빈 문자열인 경우 ("")
                        clHome.setBackgroundColor(Color.parseColor("blue"))
                    }
                    // color 키가 없을 경우
                } else {
                    clHome.setBackgroundColor(Color.parseColor("white"))
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        myRef.setValue("Hello, World2!")

        // 값 추가 감지
        // object 오버라이딩 Ctrl + O
        myRef.addValueEventListener(object : ValueEventListener {
            // 변할때
            override fun onDataChange(snapshot: DataSnapshot) {
                val message = snapshot.getValue<String>() //<String> import
                tvMsg.setText(message)
            }

            // 취소
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        contact.addChildEventListener(object : ChildEventListener{
            // 5개 오버라이딩

            // 추가 감지 보통 여기서 작성
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val webContact = snapshot.getValue<ContactVO>()
                Log.d("연락처", webContact.toString())
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            //삭제 감지
            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        return view
    }

}