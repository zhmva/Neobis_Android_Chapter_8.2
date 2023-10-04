package com.srndpty.neobisandroidchapter8.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.srndpty.neobisandroidchapter8.R
import com.srndpty.neobisandroidchapter8.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
            setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_bar_view)
        bottomNavigationView.setupWithNavController(navController)

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            navController.navigate(R.id.addProductFragment)
        }

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mainScreen -> {
                    navController.navigate(R.id.mainFragment)
                    true
                }
                R.id.userScreen -> {
                    navController.navigate(R.id.else -> false
            }
        }
    }

        fun hideBottomNav(){
            val navBar = findViewById<View>(R.id.nav_bar)
            val floatBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton)
            navBar.visibility = View.GONE
            floatBtn.visibility = View.GONE
        }

        fun showBottomNav(){
            val navBar = findViewById<View>(R.id.nav_bar)
            val floatBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton)
            navBar.visibility = View.VISIBLE
            floatBtn.visibility = View.VISIBLE
        }
}
