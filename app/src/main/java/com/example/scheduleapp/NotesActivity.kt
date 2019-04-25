package com.example.scheduleapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val toolbar : android.support.v7.widget.Toolbar  = findViewById(R.id.notes_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    /** Inflating  menu_options_notes*/
    override fun onCreateOptionsMenu(menus: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options_notes, menus)
        return true
    }
    override fun onOptionsItemSelected(items: MenuItem) = when (items.itemId) {

        R.id.save_note -> {
            val snack = Snackbar.make(window.decorView,"Test adding a new note", Snackbar.LENGTH_SHORT)
            snack.show()
            true
        }

        else -> {
            super.onOptionsItemSelected(items)
        }
    }


    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }
}
