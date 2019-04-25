package com.example.scheduleapp.presentation
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaRecorder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import com.example.scheduleapp.MainActivity
import com.example.scheduleapp.R




class IntroActivity : AppCompatActivity() {

    private lateinit var screenPager : ViewPager
    private lateinit var IntroViewPagerAdapter : IntroViewPagerAdapter
    private lateinit var tabIndicator : TabLayout
    private lateinit var btnNext : Button
    private var position : Int = 0
    private lateinit var btnGetStarted : Button
    private lateinit var btnAnim : Animation
    private lateinit var tvSkip : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        println("----------------------------------------------------------------------------------------------->>>"+restorePrefData())

            if (!restorePrefData()){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
                setContentView(R.layout.activity_intro)
                supportActionBar?.hide()





        /**Init variables*/

        btnNext = findViewById(R.id.btn_next)
        btnGetStarted = findViewById(R.id.btn_get_started)
        tabIndicator = findViewById(R.id.tab_indicator)
        btnAnim = AnimationUtils.loadAnimation(this,R.anim.button_animation)
        tvSkip = findViewById(R.id.tv_skip)


        /**fill list screen*/
        val screenList : MutableList<ScreenItem>  = ArrayList()
        screenList.add(ScreenItem("Siempre alerta","Schedule siempre te mantendra alerta, si asi lo deseas!",R.drawable.ic_xd))
        screenList.add(ScreenItem("Gestionar tu Horario","Con Schedule nunca faltaras a esa materia que tanto te gusta",R.drawable.ic_xd))
        screenList.add(ScreenItem("Comparte tu horario ","Has feliz a tus amigos compartiendo esta aplicacion",R.drawable.ic_xd))
        screenList.add(ScreenItem("Agrega tus notas","Que nada se te pase, Schedule siempre estara ahi para guardar tus recordatorios",R.drawable.ic_xd))

        screenPager =  findViewById(R.id.screen_viewpager)
        IntroViewPagerAdapter = IntroViewPagerAdapter(screenList)
        screenPager.adapter = IntroViewPagerAdapter


        tabIndicator.setupWithViewPager(screenPager)

        btnNext.setOnClickListener{
            position = screenPager.currentItem

            if (position < screenList.size) {

                position++
                screenPager.currentItem = position
            }
            if (position == screenList.size-1) { // when we rech to the last screen
                loaddLastScreen()
            }

        }

        tabIndicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == screenList.size-1){
                    loaddLastScreen()
                }

            }

        })

        btnGetStarted.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            savePrefsData()
            finish()
        }


        tvSkip.setOnClickListener{
            screenPager.currentItem = screenList.size
        }


    }


    private fun restorePrefData():Boolean{
        val pref: SharedPreferences = this.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val isIntroActivityOpnendBefore : Boolean = pref.getBoolean("isIntroOpnend",true)
        return isIntroActivityOpnendBefore
    }

    private fun savePrefsData(){
        val pref: SharedPreferences = this.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = pref.edit()
        editor.putBoolean("isIntroOpnend",false)
        editor.apply()
    }

    fun loaddLastScreen(){
        btnNext.visibility = View.INVISIBLE
        btnGetStarted.visibility = View.VISIBLE
        tvSkip.visibility  = View.INVISIBLE
        tabIndicator.visibility = View.INVISIBLE
        btnGetStarted.animation = btnAnim

    }

}
