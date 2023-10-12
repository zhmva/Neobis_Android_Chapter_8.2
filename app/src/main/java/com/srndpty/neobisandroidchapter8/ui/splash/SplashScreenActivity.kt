package com.srndpty.neobisandroidchapter8.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.srndpty.neobisandroidchapter8.databinding.ActivitySplashScreenBinding
import com.srndpty.neobisandroidchapter8.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startScreen.alpha = 0f
        binding.startScreen.animate().setDuration(1500).alpha(1f).withEndAction(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}