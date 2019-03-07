package com.example.user.mylibrary1


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.widget.Button

object Util {
    fun darkenStatusBar(activity: AppCompatActivity, color: Int) {
        val mActionBar: ActionBar? = activity.supportActionBar
        activity.window.statusBarColor = darkenColor(ContextCompat.getColor(activity, color))
        mActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(activity, color)))
    }

    fun setBackground(view: Button, colorID: Int) {
        view.setBackgroundResource(colorID)
    }

    // Code to darken the color supplied (mostly color of toolbar)
    private fun darkenColor(color: Int): Int {
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        hsv[2] *= 0.8f
        return Color.HSVToColor(hsv)
    }


}