package com.example.easyerpsolution.ui.ProductDtails.Adapters

import android.content.Context
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.easyerpsolution.ui.ProductDtails.Check_ProductDetails
import com.example.easyerpsolution.ui.ProductDtails.Description_ProductDetails
import com.example.easyerpsolution.ui.ProductDtails.Specification_ProductDetails

class ViewPagerAdapter(private val myContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                Description_ProductDetails()
            }
            1 -> {
                Specification_ProductDetails()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                Check_ProductDetails()
            }
            else -> Description_ProductDetails()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return 3
    }
}