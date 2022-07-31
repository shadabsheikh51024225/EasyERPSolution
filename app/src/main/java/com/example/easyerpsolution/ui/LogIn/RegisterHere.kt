package com.example.easyerpsolution.ui.LogIn

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityRegisterHereBinding

class RegisterHere : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterHereBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterHereBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }
        binding.textViewLogInHere.setOnClickListener {

            val i = Intent(this, LogInActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}