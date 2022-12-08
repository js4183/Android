package com.example.ex20221130

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PokeAdapter(val context: Context, val pokeList: ArrayList<PokeVO>) : BaseAdapter() {
    override fun getCount(): Int {
        // itemView(항목 뷰)가 몇 번 만들어져야 하는 지
        return pokeList.size
    }

    override fun getItem(p0: Int): Any { // p0 = position
        return pokeList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    // ★★★★★
    // p0 : position
    // p1 : itemView
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        // 0. xml -> kotlin : inflater
        val layoutInflater = LayoutInflater.from(context)
        // 1. poke_list.xml -> 코드로 접근할 수 있게
        var view = layoutInflater.inflate(R.layout.poke_list, null)
        var holder = MainActivity.ViewHolder()

        if (p1 == null) {
            Log.d("호출", "1")
            // 항목 뷰(itemView)가 안 만들어졌을 때!
            // 각 component 들을 초기화 시켜주자!!
            holder.imgPoke = view.findViewById<ImageView>(R.id.imgPoke)
            holder.tvPokeLevel = view.findViewById<TextView>(R.id.tvPokeLevel)
            holder.tvPokeName = view.findViewById<TextView>(R.id.tvPokeName)
            holder.tvPokeType = view.findViewById<TextView>(R.id.tvPokeType)

            view.tag = holder

        } else {
            Log.d("호출","2")
            holder = p1.tag as MainActivity.ViewHolder
            view = p1
        }

        holder.imgPoke = view.findViewById<ImageView>(R.id.imgPoke)
        holder.tvPokeLevel = view.findViewById<TextView>(R.id.tvPokeLevel)
        holder.tvPokeName = view.findViewById<TextView>(R.id.tvPokeName)
        holder.tvPokeType = view.findViewById<TextView>(R.id.tvPokeType)

        holder.imgPoke?.setImageResource(pokeList.get(p0).img)
        holder.tvPokeLevel?.setText(pokeList.get(p0).level)
        // tvPokeName.text=pokeList.get(p0).name
        holder.tvPokeName?.setText(pokeList.get(p0).name)
        holder.tvPokeType?.setText(pokeList.get(p0).type)



        return view
    }
}