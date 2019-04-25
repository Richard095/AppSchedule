package com.example.scheduleapp
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.scheduleapp.fragments.home_fragment
import com.example.scheduleapp.fragments.notes_fragment
import com.example.scheduleapp.fragments.subjects_fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar : android.support.v7.widget.Toolbar  = findViewById(R.id.main_activity_toolbar)
        setSupportActionBar(toolbar)

        /** All about buttonNavegation */
        val bottomNavigationView : BottomNavigationView = findViewById(R.id.botton_navegation)

        if (savedInstanceState == null) {
            val fragment = home_fragment()
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                .commit()
        }
         bottomNavigationView.setOnNavigationItemSelectedListener {
           menuItem ->
             when(menuItem.itemId){
                R.id.nav_home -> {
                    val fragment = home_fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                 R.id.nav_subject -> {
                     val fragment = subjects_fragment()
                     supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                         .commit()
                     return@setOnNavigationItemSelectedListener true
                 }

                 R.id.nav_notes -> {
                     val fragment = notes_fragment()
                     supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, fragment.javaClass.simpleName)
                         .commit()
                     return@setOnNavigationItemSelectedListener true
                 }
             }
             false

        }


    }



    /** Inflating  menu_options*/
    override fun onCreateOptionsMenu(menus: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options, menus)
        return true
    }

    override fun onOptionsItemSelected(items: MenuItem) = when (items.itemId) {
        R.id.action_about -> {
            Toast.makeText(this,"Test About",Toast.LENGTH_SHORT).show()
            true
        }
        R.id.action_help -> {
            val snack = Snackbar.make(window.decorView,"Test help", Snackbar.LENGTH_SHORT)
            snack.show()
            true
        }
        R.id.action_setting -> {
            Toast.makeText(this,"Test Settings",Toast.LENGTH_SHORT).show()
            true
        }

        else -> {
            super.onOptionsItemSelected(items)
        }
    }

}
