package com.anonymous.multiselectrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.anonymous.multiselectrecyclerview.lib.SelectableItemAdapter

class MyAdapter(items: List<MyItem>) : SelectableItemAdapter<MyViewHolder, MyItem>(items) {

    override fun provideViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val view = inflater.inflate(R.layout.item_image, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        super.onBindViewHolder(p0, p1)
        val item = items[p1]

        p0.imageView.setBackgroundColor(item.color)
        p0.textVIew.text = item.text
    }

}