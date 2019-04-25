package com.example.scheduleapp.adapters
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.graphics.Color
import android.graphics.ColorSpace
import android.graphics.drawable.GradientDrawable
import android.provider.CalendarContract
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.scheduleapp.R
import com.example.scheduleapp.fragments.Subject
import java.util.*

/**Subject viene de home fragment home */
class adapter_subjects(private val subjectList : MutableList<Subject> = ArrayList(),val context: Context):RecyclerView.Adapter<adapter_subjects.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name?.text = subjectList[position].name
        holder.tv_teacher?.text = subjectList[position].teacher
        holder.tv_classroom?.text = subjectList[position].classroom

            val colors: List<String>
            colors = ArrayList()
            colors.add("#ff9800")
            colors.add("#651fff")

            if (position %2 != 0){
                val draw = GradientDrawable()
                draw.shape = GradientDrawable.RECTANGLE
                draw.setColor(Color.parseColor(colors[0]))
                holder.tv_name.background = draw
            }
            if(position %3 == 0){
                val draw = GradientDrawable()
                draw.shape = GradientDrawable.RECTANGLE
                draw.setColor(Color.parseColor(colors[1]))
                holder.tv_name.background = draw
            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_subject,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
        val tv_teacher = itemView.findViewById<TextView>(R.id.tv_teacher)
        val tv_classroom = itemView.findViewById<TextView>(R.id.tv_classroom)
    }


}