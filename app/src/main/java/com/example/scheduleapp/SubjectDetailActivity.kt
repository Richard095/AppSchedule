package com.example.scheduleapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.scheduleapp.adapters.adapter_detail
import com.example.scheduleapp.fragments.Subject


class SubjectDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_detail)

        val toolbar : android.support.v7.widget.Toolbar  = findViewById(R.id.subject_detail_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }


        /**Datos solo de prueba*/
        val recyclerView : RecyclerView = findViewById(R.id.list_details)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val subjectList : MutableList<Subject> = ArrayList()
        subjectList.add(Subject("Lunes","Ing.Marvan Galvan Rodriguez","C5"))
        subjectList.add(Subject("Martes","Ing.Marvan Galvan Rodriguez","C4"))
        subjectList.add(Subject("Miercoles","Ing.Marvan Galvan Rodriguez","C6"))


        val adapter = adapter_detail(subjectList)
        recyclerView.adapter = adapter

    }
    /** Transition*/
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }
}
