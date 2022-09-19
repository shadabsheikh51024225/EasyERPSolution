package com.example.easyerpsolution.ui.Cart

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.easyerpsolution.R
import com.example.easyerpsolution.ui.Shipping.ShippingActivity
import com.example.easyerpsolution.databinding.ActivityCartMainBinding

class CartMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  setSupportActionBar(findViewById(R.id.main_tool_bar))
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }

        binding.toConfirmOrderBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext,ShippingActivity::class.java)
            startActivity(i)
        })
    }
    fun finish(view: View) {
        finish()
    }
}