package com.example.easyerpsolution.Final.BottomNavigationNew.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R

class TopCardAdapters : RecyclerView.Adapter<TopCardAdapters.ViewHolder>() {
    private val images = intArrayOf(
        R.drawable.tem_large_cards_two,
        R.drawable.tem_large_cards_five,
        R.drawable.tem_large_cards_four,
        R.drawable.tem_large_cards_one,
        R.drawable.tem_large_cards_three,
        R.drawable.tem_large_cards_two,
        R.drawable.tem_large_cards_five,
        R.drawable.tem_large_cards_four,
        R.drawable.tem_large_cards_one,
        R.drawable.tem_large_cards_three,
        R.drawable.tem_large_cards_two,
        R.drawable.tem_large_cards_five,
        R.drawable.tem_large_cards_four,
        R.drawable.tem_large_cards_one,
        R.drawable.tem_large_cards_three,
        R.drawable.tem_large_cards_five
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.item_image_new_activity)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.new_actvity_top_card_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])

    }

    override fun getItemCount(): Int {
        return images.size
    }
}