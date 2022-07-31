package com.example.easyerpsolution.ui.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.easyerpsolution.R
import com.example.easyerpsolution.ui.LogIn.LogInActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val i = Intent(this, LogInActivity::class.java)
            startActivity(i)
            finish()
        }, 2000)

    }
}