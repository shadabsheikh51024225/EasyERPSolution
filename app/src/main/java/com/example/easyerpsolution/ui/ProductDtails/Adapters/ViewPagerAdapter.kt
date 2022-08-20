package com.example.easyerpsolution.ui.ProductDtails.Adapters

import android.content.Context
import android.icu.text.CaseMap
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.easyerpsolution.ui.ProductDtails.Check_ProductDetails
import com.example.easyerpsolution.ui.ProductDtails.Description_ProductDetails
import com.example.easyerpsolution.ui.ProductDtails.Specification_ProductDetails

class ViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTittile = ArrayList<String>()
    // this is for fragment tabs
    override fun getItem(position: Int):  Fragment {

        return mFragmentList[position]

    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTittile[position]
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTittile.add(title)
    }
}