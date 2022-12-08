package com.example.fullstackapplication.tip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fullstackapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ListActivity : AppCompatActivity() {

    lateinit var adapter: ListAdapter //전역변수
    // 게시물의 uid 값이 들어갈 가변배열
    var keyData = ArrayList<String>()
    // bookmark 경로 설정을 위한 선언
    lateinit var bookmarkRef : DatabaseReference

    // bookmark 된 게시물의 정보가 들어갈 배열
    var bookmarkList = ArrayList<String>()
    var auth : FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // realTime 에 Database 에 필요한 객체선언
        val database = Firebase.database
        // database 에 어떤 것을 참조할건지
        val allContent = database.getReference("content") // content 있으면 가져옴, 없으면 생성
        bookmarkRef = database.getReference("bookmarklist")
        // Fragment2에서 전체보기를 눌렀을 때 가져올 데이터 담기는곳

        // push() key 타임스탬프(고유한 값을 만들어줌)를 찍어줌
        // allContent.push().setValue(
        //    ListVO("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcOYyBM%2Fbtq67Or43WW%2F17lZ3tKajnNwGPSCLtfnE1%2Fimg.png", "집", "https://philosopher-chan.tistory.com/1238")
        // )

        val rv = findViewById<RecyclerView>(R.id.rvContact)
        val tvCategory = findViewById<TextView>(R.id.tvCategory)
        val lists = ArrayList<ListVO>()

        // Fragment2 에서 intent 를 통해 보낸 데이터를 꺼내주기
        val category = intent.getStringExtra("category")
        tvCategory.text = category


        // Fragment2 에서 ImageView 를 클릭했을 때 넘어와서
        // 구현돼야할 View 들

        // TextView
        // RecyclerView ---> Adapter, data(VO), template(xml)

        // Adapter ---> ListAdapter
        // data(VO) ---> ListVO
        // template ---> layout 폴더에 list_template.xml

        // 이미지의 id (Int), title( String ---> VO로 묶어야할 데이터
        // 3 - 4개 정도 임의로 만들어 놓기
        val data = ArrayList<ListVO>()
        adapter = ListAdapter(this, data, keyData, bookmarkList)
        // FireBase 에서 데이터를 받아오는 Listener
        val postListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("snapshot", snapshot.toString())
                // Log.d("children : ", snapshot.children.toString())
                Log.d("value : ", snapshot.value.toString())
                for (model in snapshot.children){
                    val item = model.getValue(ListVO::class.java)
                    // model 에는 여러가지 게시물이 담겨있고
                    // 1개에 대한 게시물에 접근하기위해 value 를 ListVO
                    if (item != null) {
                        data.add(item)
                    }
                    keyData.add(model.key.toString())
                }
                // 데이터를 받아오는 속도가 느림 adapter 가 실행되는 속도가느림
                // 그래서 데이터를 받아온 직후에 새로고침 필요함 ~
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        allContent.addValueEventListener(postListener)

        getBookMarkData()

        // content
        // uid (게시물구분할 수 있는 uid)
        //          imgId
        //          title
        //          url


        // data.add(ListVO("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcOYyBM%2Fbtq67Or43WW%2F17lZ3tKajnNwGPSCLtfnE1%2Fimg.png", "집", "https://philosopher-chan.tistory.com/1238"))
        // data.add(ListVO("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FznKK4%2Fbtq665AUWem%2FRUawPn5Wwb4cQ8BetEwN40%2Fimg.png", "스토어", "https://philosopher-chan.tistory.com/1236"))
        // data.add(ListVO("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fekn5wI%2Fbtq66UlN4bC%2F8NEzlyot7HT4PcjbdYAINk%2Fimg.png", "꿀팁", "https://philosopher-chan.tistory.com/1239"))
        // data.add(ListVO("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FFtY3t%2Fbtq65q6P4Zr%2FWe64GM8KzHAlGE3xQ2nDjk%2Fimg.png", "지도보기", "https://philosopher-chan.tistory.com/1248"))

        // for (i in 0 until data.size){
        //     allContent.push().setValue(data[i])
        // }
        // template.xml -> imageView 하나, TextView, 북마크 ImageView

        // Adapter : 리사이클러뷰를 상속받게 만들어주세요
        // ViewHolder, OnCreateView, OnbindingView, getItemCount

        adapter = ListAdapter(this, data, keyData, bookmarkList)

        // ListActivity 에서 내가 만든 ListAdapter 를 rv에 적용하기!
        // 단 GridLayoutManager 를 사용해서 두 줄로 쌓이게 만들자
        rv.adapter = adapter
        rv.layoutManager = GridLayoutManager(this,2)

    }

    // bookmarklist에 저장되어있는 데이터를 가져오는 함수
    fun getBookMarkData(){

        val postListener2 = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                bookmarkList.clear()
                // ListActivity 를 들릴때 마다
                // 데이터가 누적
                // 1 ---> 2 ---> 4 ...
                for (model in snapshot.children){
                    Log.d("bookmark", model.toString())
                    Log.d("bookmark", model.key.toString())
                    // 북마크 게시물의 uid값을 bookmarkList에 저장
                    // 1. bookmarkList.add(model.value.toString())
                    bookmarkList.add(model.key.toString())
                    Log.d("datasize", bookmarkList.size.toString())
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        // bookmarklist 경로에 있는 데이터를 snapshot 으로 받아옴
        bookmarkRef.child(auth.currentUser!!.uid).addValueEventListener(postListener2)
    }

}