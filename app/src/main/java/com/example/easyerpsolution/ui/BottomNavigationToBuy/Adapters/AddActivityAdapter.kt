package com.example.easyerpsolution.ui.BottomNavigationToBuy.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R

class AddActivityAdapter : RecyclerView.Adapter<AddActivityAdapter.ViewHolder>() {
    private val images = intArrayOf(
        R.drawable.add_large,
        R.drawable.add_large, R.drawable.temp_add_image)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.item_image)

        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.to_buy_ad_card_items, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}