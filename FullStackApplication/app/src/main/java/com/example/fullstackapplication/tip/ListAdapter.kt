package com.example.fullstackapplication.tip

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fullstackapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ListAdapter(var context: Context, var data: ArrayList<ListVO>, var keyData:ArrayList<String>, var bookmarkList : ArrayList<String>):RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    // BaseAdapter ---> 일반 ListView
    // RecyclerView ---> RecyclerViewAdapter 상속

    val database = Firebase.database
    val auth: FirebaseAuth = Firebase.auth

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imgContent: ImageView
        val tvTitle: TextView
        val imgBookmark : ImageView

        init {
            imgContent = itemView.findViewById(R.id.imgContent)
            tvTitle = itemView.findViewById(R.id.tvTitle)
            imgBookmark = itemView.findViewById(R.id.imgMark)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate : xml 코드를 눈에보이는 View 객체로 바꿔서 ViewHolder 로 보내주는 역할
        val layoutInflater = LayoutInflater.from(context)
        // getSystemService <---- 하드웨어가 가지고 있는 많은 센서 서비스들이 담겨있음
        val view = layoutInflater.inflate(R.layout.list_template, null)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // holder.imgContent.setImageResource(data[position].imgId)
        holder.tvTitle.setText(data.get(position).title)
        Glide.with(context)
            .load(data[position].imgId)
            .into(holder.imgContent)

        // imgView 를 클릭했을 때
        // url 값을 가지고 WebViewActivity 로 넘어간다!!!
        holder.imgContent.setOnClickListener{
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url",data[position].url)
            context.startActivity(intent)
        }

        // 클릭했을 때 색깔을 바꾸면 기존에 있던 북마크는 색이 안칠해져있음
        // adapter 가 실행이 되는 순간 북마크로 있던 데이터들은 바로 색칠 될 수 있게
        if (bookmarkList.contains(keyData[position])){
            holder.imgBookmark.setImageResource(R.drawable.bookmark_color)
        }else{
            holder.imgBookmark.setImageResource(R.drawable.bookmark_white)
        }

        // 북마크 모양의 이미지를 클릭했을 때
        // 해당 게시물의 uid 값이 bookmarklist경로로 들어가야함
        holder.imgBookmark.setOnClickListener{
            // Firebase 에 있는 bookmarklist경로로 접근
            val bookmarkRef = database.getReference("bookmarklist")
            // !! 사용가능 회원이라서
            bookmarkRef.child(auth.currentUser!!.uid).child(keyData[position]).setValue("good")

            // 이미 저장이 되어있는 게시물인지 아닌지
            // bookmarkList 에 해당 게시물이 포함되어있는지
            if(bookmarkList.contains(keyData[position])){
                // 북마크를 취소
                // database 에서 해당 keyData 를 삭제
                bookmarkRef.child(auth.currentUser!!.uid).child(keyData[position]).removeValue()
                // imgbookmark 를 하얗게 만들자
                holder.imgBookmark.setImageResource(R.drawable.bookmark_white)

            }else{
                // 북마크를 추가
                // database 에 해당 keyData 를 추가
                bookmarkRef.child(auth.currentUser!!.uid).child(keyData[position]).setValue("good")

                // imgbookmark 를 까맣게 만들자
                holder.imgBookmark.setImageResource(R.drawable.bookmark_color)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}