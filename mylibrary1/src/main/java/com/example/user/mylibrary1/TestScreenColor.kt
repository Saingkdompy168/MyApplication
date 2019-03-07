package com.example.user.mylibrary1

import android.app.Activity
import android.graphics.Color
import android.support.v4.content.ContextCompat


open class TestScreenColor {
    // The public static function which can be called from other classes
    fun darkenStatusBar(activity: Activity, color: Int) {
        activity.window.statusBarColor = darkenColor(
            ContextCompat.getColor(activity, color)
        )
    }

}


// Code to darken the color supplied (mostly color of toolbar)
private fun darkenColor(color: Int): Int {
    val hsv = FloatArray(3)
    Color.colorToHSV(color, hsv)
    hsv[2] *= 0.8f
    return Color.HSVToColor(hsv)
}
