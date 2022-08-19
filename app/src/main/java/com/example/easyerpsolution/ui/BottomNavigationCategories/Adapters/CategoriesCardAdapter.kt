package com.example.easyerpsolution.ui.BottomNavigationCategories.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.ui.ProductDtails.ProductDetails


class CategoriesCardAdapter : RecyclerView.Adapter<CategoriesCardAdapter.ViewHolder>() {
    private val images = intArrayOf(
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five,
        R.drawable.temp_cat_one,
        R.drawable.temp_cat_six,
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
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five,
        R.drawable.temp_cat_four,
        R.drawable.temp_cat_one,
        R.drawable.temp_cat_six,
        R.drawable.temp_cat_one,
        R.drawable.temp_cat_six,
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five,
        R.drawable.temp_cat_four,
        R.drawable.temp_cat_one,
        R.drawable.temp_cat_four,
        R.drawable.temp_cat_one,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.item_image_categories_right_card)
            itemView.setOnClickListener(View.OnClickListener {
                val context: Context = it.getContext()
                val intent = Intent(context, ProductDetails::class.java)
                context.startActivity(intent)
            })

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.categories_right_card_item, viewGroup, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}