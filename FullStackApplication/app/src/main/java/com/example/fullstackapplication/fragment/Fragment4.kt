package com.example.fullstackapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fullstackapplication.BookmarkAdapter
import com.example.fullstackapplication.R
import com.example.fullstackapplication.tip.ListVO
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Fragment4 : Fragment() {

    // Firebase
    var auth :FirebaseAuth = Firebase.auth

    // db 접근
    var database = Firebase.database

    // ref 경로
    val contentRef = database.getReference("content")
    val bookmarkRef = database.getReference("bookmarklist")

    // ArrayList
    var data = ArrayList<ListVO>()
    var keyData = ArrayList<String>() // ListVO를 포함하는 게시물의 uid
    var bookmarkList = ArrayList<String>() // 내가 선택한 게시물 uid

    // Adapter 선언
    lateinit var adapter : BookmarkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_4, container, false)

        val bookmarkRv = view.findViewById<RecyclerView>(R.id.bookmarkRv)

        // 1. 전체 컨텐츠 데이터들을 다 가져오자
        getContentData()
        // 2. 사용자가 북마크한 정보를 다 가져오자
        getBookmarkData()
        // 3. 전체 컨텐츠 중에서 사용자가 북마크한 정보만 recyclerView 에 반영
        adapter = BookmarkAdapter(requireActivity(), data, keyData, bookmarkList)
        // 4. adapter 적용
        bookmarkRv.adapter = adapter
        bookmarkRv.layoutManager = GridLayoutManager(requireContext(), 2)



        return view
    }

    fun getContentData(){
        // content 경로에 있는 데이터를 다 가지고 오자
        // uid ---> keyData
            // - ListVO ---> data
        val posterListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for(model in snapshot.children){
                    val item = model.getValue(ListVO::class.java)
                    if(bookmarkList.contains(model.key.toString())){
                        if (item != null) {
                            data.add(item)
                            // data 내가 북마크 찍은 데이터만 남김
                        }
                    }
                    keyData.add(model.key.toString())
                }
                // adapter 새로고침 하기
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        contentRef.addValueEventListener(posterListener)
        //

    }
    fun getBookmarkData(){
        // bookmarklist경로에 있는 데이터를 다 가지고 오자
        // 게시물의 uid 값 ---> bookmarkList
        val postListener2 = object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                bookmarkList.clear()
                for (model in snapshot.children){
                    bookmarkList.add(model.key.toString())
                }
                // adapter 새로고침 하기
                adapter.notifyDataSetChanged()
                getContentData()
                // bookmarkList 에 있는 데이터만 가지고와서 data(ArrayList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        bookmarkRef.child(auth.currentUser!!.uid).addValueEventListener(postListener2)

    }

    // 반복되는 코드들이 ---> Class 함수로 사용


}