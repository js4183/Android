package com.example.ex20221201

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val context: Context, val movies: ArrayList<MovieVO>):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvRank: TextView
        val tvRankOldAndNew: TextView
        val tvMovieNm: TextView
        val tvOpenDt: TextView
        val tvAudiAcc: TextView
        init {
            tvRank = itemView.findViewById(R.id.tvRank)
            tvRankOldAndNew = itemView.findViewById(R.id.tvRankOldAndNew)
            tvMovieNm = itemView.findViewById(R.id.tvMovieNm)
            tvOpenDt = itemView.findViewById(R.id.tvOpenDt)
            tvAudiAcc = itemView.findViewById(R.id.tvAudiAcc)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // LayoutInflater 생성
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.movielist, null)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvRank.setText(movies[position].rank)
        holder.tvRankOldAndNew.setText(movies[position].rankOldAndNew)
        holder.tvMovieNm.setText(movies[position].movieNm)
        holder.tvAudiAcc.setText(movies[position].audiAcc)
        holder.tvOpenDt.setText(movies[position].openDt)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}