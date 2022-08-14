package com.example.easyerpsolution.ui.UserActivites.Coupons

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityPurseBinding
import com.example.easyerpsolution.ui.UserActivites.Coupons.Adapter.PurseAdapterUsers


class PurseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPurseBinding
    private var adapter_purse: RecyclerView.Adapter<PurseAdapterUsers.ViewHolder>? = null
    private var layoutManager_purse: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set status bar colors
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }

        //List adapter
        layoutManager_purse = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recylerListPurse.layoutManager = layoutManager_purse
        adapter_purse = PurseAdapterUsers()
        binding.recylerListPurse.adapter = adapter_purse
        binding.recylerListPurse.addItemDecoration(
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