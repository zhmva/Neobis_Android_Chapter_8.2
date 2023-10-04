package com.srndpty.neobisandroidchapter8.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.navigation.NavigationBarView
import com.srndpty.neobisandroidchapter8.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
          initBottomNav();

    }

    private fun initBottomNav() {

    }
}