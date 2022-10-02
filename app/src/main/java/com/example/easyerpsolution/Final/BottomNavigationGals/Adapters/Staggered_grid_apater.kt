package com.example.easyerpsolution.Final.BottomNavigationGals.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R


class Staggered_grid_apater : RecyclerView.Adapter<Staggered_grid_apater.ViewHolder>() {
    private val images = intArrayOf(
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,
        R.drawable.temp_gal_stag_one,
        R.drawable.temp_gal_stag_two,

    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.item_image_gal_staggered)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.gal_staggered_grid_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}