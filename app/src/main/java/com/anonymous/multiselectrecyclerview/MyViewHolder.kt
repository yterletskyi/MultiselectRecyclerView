package com.anonymous.multiselectrecyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.anonymous.multiselectrecyclerview.lib.SelectableViewHolder

class MyViewHolder(itemView: View) : SelectableViewHolder(itemView) {
    val textVIew: TextView = itemView.findViewById(R.id.textView)
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
}