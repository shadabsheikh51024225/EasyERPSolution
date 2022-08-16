package com.example.easyerpsolution.ui.UserActivites.Coupons.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import com.example.easyerpsolution.ui.UserActivites.Coupons.CouponsActivity
import com.example.easyerpsolution.ui.UserActivites.Coupons.OrderDetails
import com.example.easyerpsolution.ui.UserActivites.Coupons.TrackOrder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MyOrderAdapter() : RecyclerView.Adapter<MyOrderAdapter.ViewHolder>(){



    val imageProducts = intArrayOf(
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five,
        R.drawable.temp_cat_four,
        R.drawable.temp_cat_one,
        R.drawable.temp_cat_six,
        R.drawable.temp_cat_three,
        R.drawable.temp_cat_five,
        R.drawable.temp_cat_four,
        R.drawable.temp_cat_one,

    )



    val ListAmount = arrayOf<String>(
        "130",
        "120",
        "150",
        "130",
        "120",
        "150",
        "130",
        "120",
        "150",
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var date: TextView
        var ammount: TextView
        var productImages:ImageView
        var button_details:Button
        var button_track:Button

        init {
            date = itemView.findViewById(R.id.ordered_on_date)
            ammount = itemView.findViewById(R.id.texview_order_amount)
            productImages = itemView.findViewById(R.id.my_order_image)
            button_details = itemView.findViewById(R.id.button_order_details)
            button_track = itemView.findViewById(R.id.button_track_order)

        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.my_order_item, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.ammount.setText("Total: $"+ListAmount[i])
        val dateFormat: SimpleDateFormat? = SimpleDateFormat("MM-dd-yyyy")
        val df: DateFormat = SimpleDateFormat("h:mm a")
        val date = df.format(Calendar.getInstance().time)
        viewHolder.date.setText(dateFormat?.format(Date()))
        viewHolder.productImages.setImageResource(imageProducts[i])
        val context: Context = viewHolder.itemView.getContext()
        viewHolder.button_details.setOnClickListener(View.OnClickListener {

            val i = Intent(context, OrderDetails::class.java)
            startActivity(context,i,null)
        })
        viewHolder.button_track.setOnClickListener(View.OnClickListener {

            val i = Intent(context, TrackOrder::class.java)
            startActivity(context,i,null)
        })
    }

    override fun getItemCount(): Int {
        return ListAmount.size
    }
}