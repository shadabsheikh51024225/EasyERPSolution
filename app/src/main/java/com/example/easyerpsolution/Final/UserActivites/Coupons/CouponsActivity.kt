package com.example.easyerpsolution.Final.UserActivites.Coupons

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityCouponsBinding
import com.example.easyerpsolution.Final.UserActivites.Coupons.Adapter.ListAdapaterUserCoupons



class CouponsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCouponsBinding
    private var adapter_list_coupons: RecyclerView.Adapter<ListAdapaterUserCoupons.ViewHolder>? = null
    private var layoutManager_coupons: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCouponsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }

        //toolbar
        setSupportActionBar(binding.couponsToolbar)
        binding.couponsToolbar.setNavigationOnClickListener(View.OnClickListener {
            R.id.toolbar_arrow
        })

        //list adapter
        val listImagecoupons = arrayOf(
            R.drawable.temp_cupons_one,
            R.drawable.temp_cupons_one,
            R.drawable.temp_cupons_two,
            R.drawable.temp_cupons_one,
            R.drawable.temp_cupons_two,
            R.drawable.temp_cupons_two,
            R.drawable.temp_cupons_one,
            R.drawable.temp_cupons_one,
            R.drawable.temp_cupons_two,
        )

        val text_list = arrayOf<String>(
            "Coupons", "Purse", "Points", "My orders",
            "Wish list",
            "Adjustments",
            "Comments",
            "Return",
            "Support"
        )
        val listImage = arrayOf<Int>(
            R.drawable.me_cupons_three,
            R.drawable.me_purse_three,
            R.drawable.me_points,
            R.drawable.me_my_orders_three,
            R.drawable.me_wish_list_three,
            R.drawable.me_adjustment_thee,
            R.drawable.me_comments_three,
            R.drawable.me_returen_three,
            R.drawable.me_support_three
        )

        layoutManager_coupons = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.couponsRecyclerListView.layoutManager = layoutManager_coupons
        adapter_list_coupons = ListAdapaterUserCoupons()
        binding.couponsRecyclerListView.adapter = adapter_list_coupons
    }

    fun finish(view: View) {
        finish()
    }
}
