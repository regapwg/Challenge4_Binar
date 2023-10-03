package com.example.challenge2_binar

import android.content.Context
import androidx.core.content.edit

class SharedPreference(context: Context) {
    private val sharedPreference = "sharedPreferenceBinarMart"
    private var prefernce = context.getSharedPreferences(sharedPreference, Context.MODE_PRIVATE)

    var isGrid: Boolean
        set(value) {
            prefernce.edit{
                putBoolean("IS_GRID", value)
            }
        }
        get() = prefernce.getBoolean("IS_GRID", false)
}