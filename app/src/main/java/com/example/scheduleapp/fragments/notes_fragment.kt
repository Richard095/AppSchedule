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
import com.example.scheduleapp.NotesActivity
import com.example.scheduleapp.R
import com.example.scheduleapp.adapters.adapter_notes
import org.w3c.dom.Text



/**Data get|set Notes*/
data class Notes(val title: String, val description: String,val date : String)

class notes_fragment : Fragment() {
    companion object {
        fun newInstanse():notes_fragment{
            return notes_fragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val View = inflater.inflate(R.layout.fragment_notes,container,false)
        val recyclerView : RecyclerView = View.findViewById(R.id.list_notes)

        val add_notes_button = View.findViewById<FloatingActionButton>(R.id.fab_notes)


        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        /**Datos solode prueba */

        val notesList : MutableList<Notes> = ArrayList()
        notesList.add(Notes("Examen de calculo integral","Examen proxima semana!","15-04-2019"))
        notesList.add(Notes("Tarea de mate","Para proxima semana!","23-04-2019"))
        notesList.add(Notes("Examen de calculo integral","Examen proxima semana!","15-04-2019"))
        notesList.add(Notes("Tarea de mate","Para proxima semana!","23-04-2019"))
        notesList.add(Notes("Examen de calculo integral","Examen proxima semana!","15-04-2019"))
        notesList.add(Notes("Tarea de mate","Para proxima semana!","23-04-2019"))

        val adapter = adapter_notes(notesList)
        recyclerView.adapter = adapter




        /**Event for show Notes activity*/

        add_notes_button.setOnClickListener {
            val intent = Intent(activity, NotesActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)

        }



        return View
    }


}