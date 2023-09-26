package com.example.challenge2_binar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GridLayoutCh2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_grid_ch2)
        Log.e("InisialisasiState", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("InisialisasiState", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("InisialisasiState", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("InisialisasiState", "onPause")
    }
    override fun onRestart() {
        super.onRestart()
        Log.e("InisialisasiState", "onRestart")
    }
    override fun onStop() {
        super.onStop()
        Log.e("InisialisasiState", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("InisialisasiState", "onDestroy")
    }
}

