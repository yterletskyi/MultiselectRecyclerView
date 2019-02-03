package com.anonymous.multiselectrecyclerview.lib

import android.support.v7.widget.RecyclerView
import android.view.View
import com.anonymous.multiselectrecyclerview.R

abstract class SelectableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val viewMark: View = itemView.findViewById(R.id.viewMark)
    val viewOverlay: View = itemView.findViewById(R.id.viewOverlay)
}