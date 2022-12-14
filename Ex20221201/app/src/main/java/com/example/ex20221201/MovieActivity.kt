package com.example.ex20221201

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MovieActivity : AppCompatActivity() {

    // Volley 에 필요한 객체 2개
    var queue: RequestQueue? = null // 요청을 가지고 서버로 이동하는 객체
    lateinit var request: StringRequest // 요청/응답이 들어가는 객체
    var movies = ArrayList<MovieVO>() // 영화정보들이 담긴 배열

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        // Volley 를 통한 네트워크 통신 4단계
        // 1. Volley 설정
        // - Volley 라이브러리 추가
        // - Manifest 에 Permission 추가!! -> Internet
        // 2. RequestQueue 생성
        // 3. Request 생성
        // 4. RequestQueue 에 Request 추가!!



        // 1) Container 결정
        val rc = findViewById<RecyclerView>(R.id.rc)
        val btnMovie = findViewById<Button>(R.id.btnMovie)
        val etInput = findViewById<EditText>(R.id.etInput)

        // 2) Template 결정
        // movie_list.xml

        // 3) Item 결정
        // movies = ArrayList<MovieVO>


        // 버튼을 클릭하거나, 에뮬레이터를 작동, OnCreate 가 실행될때마다
        // request 가 들어갈 장소를 만들고 있음
        if (queue == null) {
            queue = Volley.newRequestQueue(this@MovieActivity)
        }

        // 4) Adapter 결정
        val adapter = MovieAdapter(this, movies)
        
        // 5) Container 에 Adapter 부착
        rc.adapter = adapter
        rc.layoutManager = LinearLayoutManager(this)

        // btnMovie 를 클릭했을 때 영화정보를 (response) Log 로 확인해보기
        btnMovie.setOnClickListener {
            movies.clear()
            val date = etInput.text.toString()

            val url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=$date"

            // 대체적으로 문자열로 주고 받음
            request = StringRequest(
                // 1. 전송방식 get/post
                Request.Method.GET,
                // 2. URL
                url,
                //"https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20221130",
                // 3. 응답 성공시 Listener it이 나옴 -> response 직관적으로 확인할수있게
                { response ->
                    // 응답받아온 response : String
                    val json1 = JSONObject(response)
                    Log.d("json1", json1.toString())
                    val json2 = json1.getJSONObject("boxOfficeResult")
                    Log.d("json2", json2.toString())
                    val json3 = json2.getJSONArray("dailyBoxOfficeList")
                    Log.d("json3", json3.toString())

                    //val movie = json3.getJSONObject(0)
                    //val rank = movie.getString("rank")
                    //Log.d("rank", rank)

                    // JsonArray 에 순차적으로 접근해서 영화 정보 꺼내오기
                    for (i in 0 until json3.length()) {
                        val movie = json3.getJSONObject(i)
                        // rank
                        var rank = movie.getString("rank")
                        // rankOldAndNew
                        var rankOldAndNew = movie.getString("rankOldAndNew")
                        // movieNm
                        var movieNm = movie.getString("movieNm")
                        Log.d("영화", movieNm)
                        // openDt
                        var openDt = movie.getString("openDt")
                        // audiAcc
                        var audiAcc = movie.getString("audiAcc")
                        // 하나의 자료형 MovieVO
                        // MovieVO 를 ArrayList 에 저장
                        movies.add(MovieVO(rank, rankOldAndNew, movieNm, audiAcc, openDt))
                    }
                    adapter.notifyDataSetChanged()
                },
                { error -> }
            )


            queue?.add(request)
        }
    }
}