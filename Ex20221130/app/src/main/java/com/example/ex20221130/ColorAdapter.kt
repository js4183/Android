package com.example.ex20221130

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(val context: Context, val colorList: ArrayList<ColorVO>) :
    RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val clColor: ConstraintLayout

        init {
            clColor = itemView.findViewById<ConstraintLayout>(R.id.clColor)

            itemView.setOnClickListener{
                val position = adapterPosition
                val color = colorList.get(position).color
                // context 넘겨진 페이지 정보 Context Class
                val sharedPreferences = context.getSharedPreferences("sp1", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("bgColor", color)
                editor.commit()
                (context as Activity).finish()

                // System.exit(0)
            }
        }
    }

    // view xml->code 로 변환 inflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.color_list, null)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val color:String = colorList.get(position).color
        holder.clColor.setBackgroundColor(Color.parseColor(color))
    }

    // 아이템이 몇개인지
    override fun getItemCount(): Int {
        return colorList.size
    }
}