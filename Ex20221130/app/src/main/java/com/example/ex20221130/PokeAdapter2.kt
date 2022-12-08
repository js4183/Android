package com.example.ex20221130

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PokeAdapter2(val context:Context, val pokeList: ArrayList<PokeVO>) : RecyclerView.Adapter<PokeAdapter2.ViewHolder>() {

    // Java 에서는 OnClickEvent 를 구현한다!! (Interface 형태로)

    // inner class 명시를 해야함!
    // outer class 의 member 에 접근 할 수 있다
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imgPoke:ImageButton
        val tvPokeLevel:TextView
        val tvPokeName:TextView
        val tvPokeType:TextView

        init {
            imgPoke = itemView.findViewById(R.id.imgPoke)
            tvPokeLevel = itemView.findViewById(R.id.tvPokeLevel)
            tvPokeName = itemView.findViewById(R.id.tvPokeName)
            tvPokeType = itemView.findViewById(R.id.tvPokeType)

            // 개발자 중에 '아니... itemView 클릭하는 이벤트를 왜 어댑터에 만듦?'
            // '아니... 이 이벤트는 이 RecyclerView 와 이 Adapter 전용인데 여기에 만드는게 뭐가 문제됨?'

            // 1. ListView 의 setOnItemClickListener
            itemView.setOnClickListener {
                // 해당 아이템의 position 정보가 필요함! -> adapterPosition
                val position:Int = adapterPosition
                pokeList.removeAt(position)
                notifyDataSetChanged()
            }

            imgPoke.setOnClickListener{
                // 피카츄 -> 피카츄입니다!!
                val position:Int = adapterPosition
                // "Lv : 1 / 피카츄 / 타입 : 전기"
                val level:String = pokeList.get(position).level
                val name:String = pokeList.get(position).name
                val type:String = pokeList.get(position).type

                val result:String = "$level / $name / 타입 : $type"

                // Ctrl + C , Ctrl + V
                // 코드는 다 쳐야 적성에 풀리시는 분들

                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
            }

        }
    }

    // itemView 가 없을때, ViewHolder 생성!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.poke_list, null)

        return ViewHolder(view)
    }

    // 만들어진 ViewHolder 가 있다면, 꺼내서 쓰는 곳!!
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imgPoke.setImageResource(pokeList.get(position).img)
        //holder.imgPoke.setImageResource() imageView -> imageButton 기능 사용 가능
        holder.tvPokeLevel.setText(pokeList.get(position).level)
        holder.tvPokeName.setText(pokeList.get(position).name)
        holder.tvPokeType.setText(pokeList.get(position).type)
    }


    override fun getItemCount(): Int {
        return pokeList.size
    }


}