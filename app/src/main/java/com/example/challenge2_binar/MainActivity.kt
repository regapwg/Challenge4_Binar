package com.example.challenge2_binar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//    lateinit var binding: ActivityMainBinding
private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)


//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navBarBottom)
//        val navcon = findNavController(R.id.fragment)
//
//        bottomNavigationView.setupWithNavController(navcon)


//        binding.navBarBottom.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.homeFragment -> findNavController(R.id.homeFragment)
//                R.id.keranjangFragment -> findNavController(R.id.keranjangFragment)
//                R.id.profileFragment -> findNavController(R.id.profileFragment)
//                else -> {}
//            }
//            true
//
//        }

    val bottomNavView = findViewById<BottomNavigationView>(R.id.navBarBottom)
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
    navController = navHostFragment.navController

    // Connect the BottomNavigationView to the NavController
    NavigationUI.setupWithNavController(bottomNavView, navController)

    }
}