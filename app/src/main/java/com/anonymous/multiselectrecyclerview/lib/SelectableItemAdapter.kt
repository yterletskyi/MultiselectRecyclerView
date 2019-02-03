package com.anonymous.multiselectrecyclerview.lib

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup


abstract class SelectableItemAdapter<HOLDER : SelectableViewHolder, ITEM : SelectableItem>(
    protected val items: List<ITEM>
) : RecyclerView.Adapter<HOLDER>() {

    private val isSelectMode: Boolean get() = items.any { it.selected }

    abstract fun provideViewHolder(p0: ViewGroup, p1: Int): HOLDER

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HOLDER {
        val holder = provideViewHolder(p0, p1)

        holder.itemView.setOnLongClickListener {
            toggleSelection(holder.adapterPosition)
            return@setOnLongClickListener true
        }
        holder.itemView.setOnClickListener {
            if (!isSelectMode) return@setOnClickListener
            toggleSelection(holder.adapterPosition)
        }
        return holder
    }

    private fun toggleSelection(position: Int) {
        val item = items[position]

        val oldSelected = isSelectMode
        item.selected = !item.selected
        val newSelected = isSelectMode

        if (oldSelected != newSelected) {
            notifyDataSetChanged()
        } else {
            notifyItemChanged(position)
        }
    }

    override fun onBindViewHolder(p0: HOLDER, p1: Int) {
        val item = items[p1]
        p0.viewOverlay.visibility = if (item.selected) View.VISIBLE else View.GONE
        p0.viewMark.visibility = if (isSelectMode) View.VISIBLE else View.GONE
        p0.viewMark.isSelected = item.selected
    }

    override fun getItemCount(): Int = items.size

}