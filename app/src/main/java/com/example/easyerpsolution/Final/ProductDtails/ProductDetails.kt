package com.example.easyerpsolution.Final.ProductDtails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.databinding.ActivityProductDetailsBinding
import com.example.easyerpsolution.Final.ProductDtails.Adapters.ViewPagerAdapter
import com.example.easyerpsolution.Final.ProductDtails.Adapters.ProductDetailsAdapterGrid

class ProductDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    private var layoutManager_product_detais_grid: RecyclerView.LayoutManager? = null
    private var adapter_product_details_grid: RecyclerView.Adapter<ProductDetailsAdapterGrid.ViewHolder>? =
        null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set status bar colors
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Primary_color)
        }

        //grid layout for right cards.
        layoutManager_product_detais_grid =
            GridLayoutManager(applicationContext, 1, LinearLayoutManager.HORIZONTAL, true)
        binding.recyclerviewProductDetailsGrid.layoutManager = layoutManager_product_detais_grid
        adapter_product_details_grid = ProductDetailsAdapterGrid()
        binding.recyclerviewProductDetailsGrid.adapter = adapter_product_details_grid


        //setting textview cancelable
        var cancle = "$260"
        val ssb = SpannableStringBuilder(cancle)
        ssb.setSpan(
            StrikethroughSpan(),
            0, // start of the span (inclusive)
            4, // end of the span (exclusive)
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.texviewOrderAmountCancle.text = ssb

        //spinner settings
        val languages = resources.getStringArray(R.array.select_size)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, languages
        )
        binding.spinner.adapter = adapter


        // tab layout default state.
    //    var tab = binding.tabLayoutProductDetails.getTabAt(2)
   //     binding.tabLayoutProductDetails.selectTab(tab)
    setUpTabs()
    }

    private fun setUpTabs() {
        val viewPager= binding.tabViewpager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Description_ProductDetails(),"Description")
        adapter.addFragment(Specification_ProductDetails(),"Specification")
        adapter.addFragment(Check_ProductDetails(),"Checks")
        viewPager.adapter = adapter
        binding.tabLayoutProductDetails.setupWithViewPager(viewPager)

    }


    fun finish(view: View) {
        finish()
    }
}