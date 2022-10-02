package com.example.easyerpsolution.Final.BottomNavigationToBuy.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R

class NewProductsAdapter : RecyclerView.Adapter<NewProductsAdapter.ViewHolder>() {
    private val images = intArrayOf(
        R.drawable.tem_new_product_one,
        R.drawable.tem_new_product_two,
        R.drawable.tem_new_product_one,
        R.drawable.tem_new_product_two,
        R.drawable.tem_new_product_one,
        R.drawable.tem_new_product_two,
        R.drawable.tem_new_product_one,
        R.drawable.tem_new_product_two,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView



        init {
            itemImage = itemView.findViewById(R.id.item_image_new_products)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.to_buy_new_products_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])

    }

    override fun getItemCount(): Int {
        return images.size
    }
}