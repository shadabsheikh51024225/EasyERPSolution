package com.example.easyerpsolution.ui.ProductDtails.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R

class ProductDetailsAdapterGrid : RecyclerView.Adapter<ProductDetailsAdapterGrid.ViewHolder>() {
    private val images = intArrayOf(
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five,
        R.drawable.temp_cat_one,
        R.drawable.temp_cat_six,
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.item_image_product_details)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_details_items, viewGroup, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}