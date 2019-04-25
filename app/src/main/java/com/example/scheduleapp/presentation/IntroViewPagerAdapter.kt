package com.example.scheduleapp.presentation
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.scheduleapp.R


class IntroViewPagerAdapter (private var screenList: MutableList<ScreenItem> = ArrayList()) :

    PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.layout_screen,container,false)

        val imgSlide: ImageView = view.findViewById(R.id.intro_img)
        val title: TextView = view.findViewById(R.id.intro_title)
        val description: TextView = view.findViewById(R.id.intro_description)

        imgSlide.setImageResource(screenList.get(position).ScreenImg)
        title.text = screenList.get(position).tittle
        description.text = screenList.get(position).description


        container.addView(view)

        return view

    }

    override fun isViewFromObject(v: View, p1: Any): Boolean {
        return v === p1
    }

    override fun getCount(): Int {
        return screenList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, view : Any) {
        container.removeView(view  as View)
    }
}