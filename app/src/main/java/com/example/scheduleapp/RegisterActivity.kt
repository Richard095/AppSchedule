package com.example.scheduleapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast


class RegisterActivity : AppCompatActivity() {

    private lateinit var layoutAnim : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val toolbar : android.support.v7.widget.Toolbar  = findViewById(R.id.register_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }



        val check_mon : CheckBox = findViewById(R.id.checkbox_mon)
        val check_tue : CheckBox = findViewById(R.id.checkbox_tue)
        val check_wed : CheckBox = findViewById(R.id.checkbox_wed)
        val check_thu : CheckBox = findViewById(R.id.checkbox_thu)
        val check_fri : CheckBox = findViewById(R.id.checkbox_fri)

        val container_mon : LinearLayout = findViewById(R.id.container_mon)
        val container_tue : LinearLayout = findViewById(R.id.container_tue)
        val container_wed : LinearLayout = findViewById(R.id.container_wed)
        val container_thu : LinearLayout = findViewById(R.id.container_thu)
        val container_fri : LinearLayout = findViewById(R.id.container_fri)

        layoutAnim = AnimationUtils.loadAnimation(this,R.anim.button_animation)

        

        /**Showing form Time Containers */
        check_mon.setOnClickListener{
            if (check_mon.isChecked) {
                container_mon.visibility = View.VISIBLE
                container_mon.animation = layoutAnim
                layoutAnim.start()

            } else {
                container_mon.visibility = View.GONE
            }
        }
        check_tue.setOnClickListener{
            if (check_tue.isChecked) {
                container_tue.visibility = View.VISIBLE
                container_tue.animation = layoutAnim
                layoutAnim.start()
            } else {
                container_tue.visibility = View.GONE
            }
        }
        check_wed.setOnClickListener{
            if (check_wed.isChecked) {
                container_wed.visibility = View.VISIBLE
                container_wed.animation = layoutAnim
                layoutAnim.start()
            } else {
                container_wed.visibility = View.GONE
            }
        }

        check_thu.setOnClickListener{
            if (check_thu.isChecked) {
                container_thu.visibility = View.VISIBLE
                container_thu.animation = layoutAnim
                layoutAnim.start()
            } else {
                container_thu.visibility = View.GONE
            }
        }
        check_fri.setOnClickListener{
            if (check_fri.isChecked) {
                container_fri.visibility = View.VISIBLE
                container_fri.animation = layoutAnim
                layoutAnim.start()
            } else {
                container_fri.visibility = View.GONE
            }
        }

    }
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }



    /** Inflating  menu_options_notes*/
    override fun onCreateOptionsMenu(menus: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options_register, menus)
        return true
    }
    override fun onOptionsItemSelected(items: MenuItem ) = when (items.itemId) {

        R.id.save_subject -> {
            val snack = Snackbar.make(window.decorView,"Test adding a new subject",Snackbar.LENGTH_SHORT)
            snack.show()
            true
        }

        else -> {
            super.onOptionsItemSelected(items)
        }
    }


}
