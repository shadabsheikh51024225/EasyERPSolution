package com.example.easyerpsolution.Final.UserActivites.Coupons

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityMyOrdersBinding
import com.example.easyerpsolution.Final.UserActivites.Coupons.Adapter.MyOrderAdapter

class MyOrders : AppCompatActivity() {
    private lateinit var binding: ActivityMyOrdersBinding
    private var adapter_myOrder: RecyclerView.Adapter<MyOrderAdapter.ViewHolder>? = null
    private var layoutManager_myOrder: RecyclerView.LayoutManager? = null
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
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, languages
        )
        binding.spinner.adapter = adapter

        //List adapter
        layoutManager_myOrder = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recylerListMyOrder.layoutManager = layoutManager_myOrder
        adapter_myOrder = MyOrderAdapter()
        binding.recylerListMyOrder.adapter = adapter_myOrder
        binding.recylerListMyOrder.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )


    }

    fun finish(view: View) {
        finish()
    }
}