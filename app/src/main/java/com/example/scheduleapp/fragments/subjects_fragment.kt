package com.example.scheduleapp.fragments

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.scheduleapp.R
import com.example.scheduleapp.RegisterActivity
import com.example.scheduleapp.SubjectDetailActivity
import com.example.scheduleapp.adapters.adapter_all_subjects


class subjects_fragment : Fragment() {
    companion object {
        fun newInstanse():subjects_fragment{
            return subjects_fragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val View =  inflater.inflate(R.layout.fragment_subjects,container,false)

        val add_subjects_button = View.findViewById<FloatingActionButton>(R.id.fab_all_subjects)
        val recyclerView : RecyclerView = View.findViewById(R.id.list_all_subject)

        /**Event for show registerView*/

        add_subjects_button.setOnClickListener {
            val intent = Intent(activity, RegisterActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)

        }


        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        /**Datos solode prueba */
        val subjectList : MutableList<Subject> = ArrayList()

        subjectList.add(Subject("Ecuaciones DIferencials","Ing.Marvan Galvan Rodriguez","C5"))
        subjectList.add(Subject("Calculo Integral","Ing.Marvan Galvan Rodriguez","C4"))
        subjectList.add(Subject("Calculo Diferencial","Ing.Marvan Galvan Rodriguez","C6"))
        subjectList.add(Subject("Calculo Vectorial","Ing.Marvan Galvan Rodriguez","C5"))
        subjectList.add(Subject("Calculo Integral","Ing.Marvan Galvan Rodriguez","C4"))
        subjectList.add(Subject("Calculo Diferencial","Ing.Marvan Galvan Rodriguez","C6"))
        subjectList.add(Subject("Calculo Vectorial","Ing.Marvan Galvan Rodriguez","C5"))
        subjectList.add(Subject("Calculo Integral","Ing.Marvan Galvan Rodriguez","C4"))
        subjectList.add(Subject("Calculo Diferencial","Ing.Marvan Galvan Rodriguez","C6"))

        var adapter = adapter_all_subjects(subjectList)
        recyclerView.adapter = adapter

        /** Function onClickListener for TextView Details  */
        adapter.onItemClick = { subject ->
            val intent = Intent(activity,SubjectDetailActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
            Toast.makeText(context,"Clicked ${subject.name} ",Toast.LENGTH_SHORT).show()
        }

        return View
    }
}