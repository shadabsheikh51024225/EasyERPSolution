package com.example.easyerpsolution.ui.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.easyerpsolution.MainActivity
import com.example.easyerpsolution.R
import java.util.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }, 2000)

    }
}