package com.example.easyerpsolution.ui.UserActivites.Coupons.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easyerpsolution.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class PurseAdapterUsers  : RecyclerView.Adapter<PurseAdapterUsers.ViewHolder>() {




    //list adapter
    val listorderId = arrayOf<String>(
        "Order pace id#5855661",
        "Add money successfully",
        "Order pace id#5855661",
        "Order pace id#5855661",
        "Order pace id#5855661",
        "Add money successfully",
        "Add money successfully",
        "Order pace id#5855661",
        "Order pace id#5855661",
    )
    val ListAmount = arrayOf<String>(
        "30",
        "20",
        "50",
        "30",
        "20",
        "50",
        "30",
        "20",
        "50",
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var date:TextView
        var time:TextView
        var ammount:TextView
        var orderId:TextView


        init {
            date = itemView.findViewById(R.id.textView_wallet_date)
            time = itemView.findViewById(R.id.wallet_text_view_time)
            ammount = itemView.findViewById(R.id.order_amount)
            orderId = itemView.findViewById(R.id.order_id)

        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.purse_list_item, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.orderId.setText(listorderId[i])
        viewHolder.ammount.setText(ListAmount[i]+"$").also {
            if(ListAmount.get(i).toInt()>20)
            {
                viewHolder.ammount.setTextColor(R.color.green)
            }
            else
            {
                viewHolder.ammount.setTextColor(R.color.red)
            }
        }
        val dateFormat: SimpleDateFormat? = SimpleDateFormat("MM-dd-yyyy")
        val df: DateFormat = SimpleDateFormat("h:mm a")
        val date = df.format(Calendar.getInstance().time)
        viewHolder.time.setText(date)
        viewHolder.date.setText(dateFormat?.format(Date()))

    }

    override fun getItemCount(): Int {
        return listorderId.size
    }
}