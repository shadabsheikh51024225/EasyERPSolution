package com.example.easyerpsolution.Final.ProductDtails.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R

class Checks_product_detail_card_adapter : RecyclerView.Adapter<Checks_product_detail_card_adapter.ViewHolder>() {
    private val images = intArrayOf(
        R.drawable.temp_product_details_user,
        R.drawable.temp_product_details_user,
        R.drawable.temp_product_details_user,
        R.drawable.temp_product_details_user,
        R.drawable.temp_product_details_user,
        R.drawable.temp_product_details_user
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.checks_user_id)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.checks_item_product_details, viewGroup, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}