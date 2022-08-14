package com.example.easyerpsolution.ui.UserActivites.Coupons.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters.AddActivityAdapter


class ListAdapaterUserCoupons : RecyclerView.Adapter<ListAdapaterUserCoupons.ViewHolder>() {
    //list adapter
    val listImagecoupons = arrayOf<Int>(
        R.drawable.temp_cupons_one,
        R.drawable.temp_cupons_one,
        R.drawable.temp_cupons_one,
        R.drawable.temp_cupons_one,
        R.drawable.temp_cupons_one,
        R.drawable.temp_cupons_one,
        R.drawable.temp_cupons_one,
        R.drawable.temp_cupons_one,
        R.drawable.temp_cupons_one,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.list_image_coupons)

        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.coupons_list_items, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(listImagecoupons[i])
    }

    override fun getItemCount(): Int {
        return listImagecoupons.size
    }
}