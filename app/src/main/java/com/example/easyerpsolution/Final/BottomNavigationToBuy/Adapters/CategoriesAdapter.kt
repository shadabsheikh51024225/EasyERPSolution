package com.example.easyerpsolution.Final.BottomNavigationToBuy.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    private val images = intArrayOf(
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five,
        R.drawable.temp_cat_four,
        R.drawable.temp_cat_one,
        R.drawable.temp_cat_six,
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five,
        R.drawable.temp_cat_four,
        R.drawable.temp_cat_one,
        R.drawable.temp_cat_six,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemText: TextView


        init {
            itemImage = itemView.findViewById(R.id.item_image_categories)
            itemText = itemView.findViewById(R.id.text_view_categories)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.to_buy_categories_items, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])

    }

    override fun getItemCount(): Int {
        return images.size
    }
}