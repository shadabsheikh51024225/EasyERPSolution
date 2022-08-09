package com.example.easyerpsolution.ui.BottomNavigationMe.Adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.easyerpsolution.R

class ListAdapaterUser (private val context: Activity, private val title: Array<String>, private val imgid: Array<Int>)
    : ArrayAdapter<String>(context, R.layout.me_list_view_item, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.me_list_view_item, null, true)

        val titleText = rowView.findViewById(R.id.list_text) as TextView
        val imageView = rowView.findViewById(R.id.list_image) as ImageView


        titleText.text = title[position]
        imageView.setImageResource(imgid[position])


        return rowView
    }
}