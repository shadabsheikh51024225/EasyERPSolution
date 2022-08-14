package com.example.easyerpsolution.ui.UserActivites.Coupons

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityCouponsBinding
import com.example.easyerpsolution.databinding.ActivityMyOrdersBinding

class MyOrders : AppCompatActivity() {
    private lateinit var binding: ActivityMyOrdersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting action bar color.
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }

        //spinner
        val languages = resources.getStringArray(R.array.frequancy)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, languages)
       binding.spinner.adapter = adapter
    }
    fun finish(view: View) {
        finish()
    }
}