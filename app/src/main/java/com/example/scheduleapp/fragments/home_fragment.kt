package com.example.scheduleapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.scheduleapp.R
import com.example.scheduleapp.adapters.adapter_subjects

/** Subjects Data   gets | sets  |   Lo uso para todo los adapters a excepcion de las notas*/
data class Subject(val name: String, val teacher: String,val classroom : String)

class home_fragment : Fragment() {

    companion object {
        fun newInstanse():home_fragment{
            return home_fragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val View = inflater.inflate(R.layout.fragment_home,container,false)
        val recyclerView : RecyclerView = View.findViewById(R.id.list_subject)

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        val subjectList : MutableList<Subject> = ArrayList()

        /**Datos de prueba falta lo de las horas, sin envargo el view ya esta listo */

        subjectList.add(Subject("Ecuaciones DIferencials","Ing.Marvan Galvan Rodriguez","C5"))
        subjectList.add(Subject("Calculo Integral","Ing.Marvan Galvan Rodriguez","C4"))
        subjectList.add(Subject("Calculo Diferencial","Ing.Marvan Galvan Rodriguez","C6"))
        subjectList.add(Subject("Calculo Vectorial","Ing.Marvan Galvan Rodriguez","C5"))
        subjectList.add(Subject("Calculo Integral","Ing.Marvan Galvan Rodriguez","C4"))
        subjectList.add(Subject("Calculo Diferencial","Ing.Marvan Galvan Rodriguez","C6"))
        subjectList.add(Subject("Calculo Vectorial","Ing.Marvan Galvan Rodriguez","C5"))
        subjectList.add(Subject("Calculo Integral","Ing.Marvan Galvan Rodriguez","C4"))
        subjectList.add(Subject("Calculo Diferencial","Ing.Marvan Galvan Rodriguez","C6"))

        var adapter = adapter_subjects(subjectList,this.requireActivity() )
        recyclerView.adapter = adapter
        return View
    }


}