package com.example.scheduleapp.adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.scheduleapp.R
import com.example.scheduleapp.fragments.Notes

/**Notes viene de home fragment notes*/

class adapter_notes(private val notesList : MutableList<Notes> = ArrayList()):RecyclerView.Adapter<adapter_notes.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_title?.text = notesList[position].title

    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_notes,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return notesList.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_title = itemView.findViewById<TextView>(R.id.title_note)
        val container_all  = itemView.findViewById<LinearLayout>(R.id.container_all)
    }



}