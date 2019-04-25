package com.example.scheduleapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.scheduleapp.R
import com.example.scheduleapp.fragments.Subject

/**Subject viene de home fragment */

class adapter_all_subjects(private val subjectList : MutableList<Subject> = ArrayList()):RecyclerView.Adapter<adapter_all_subjects.ViewHolder>() {


    var onItemClick: ((Subject) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name?.text = subjectList[position].name
        holder.tv_show_details?.text  = "Detalles >"

        if (position %2 != 0){
            holder.image.setImageResource(R.drawable.ic_stars_yellow_24dp)
        }
        if(position %3 == 0){
            holder.image.setImageResource(R.drawable.ic_stars_blue_24dp)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_all_subject,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name_subject)
        val tv_show_details = itemView.findViewById<TextView>(R.id.tv_show_details)
        val image = itemView.findViewById<ImageView>(R.id.icon_start)

        /**Method onclick*/
        init {
            tv_show_details.setOnClickListener {
                onItemClick?.invoke(subjectList[adapterPosition])
            }
        }

    }


}