package com.example.scheduleapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.scheduleapp.R
import com.example.scheduleapp.fragments.Subject

/**Subject viene de home fragment */
class adapter_detail(private val subjectList : MutableList<Subject> = ArrayList()):RecyclerView.Adapter<adapter_detail.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.day?.text = subjectList[position].name  //Solo aqui va el dia
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_detail_subject,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val day = itemView.findViewById<TextView>(R.id.day)
        val tv_star_class = itemView.findViewById<TextView>(R.id.tv_star_class)
        val tv_end_class = itemView.findViewById<TextView>(R.id.tv_end_class)
    }


}