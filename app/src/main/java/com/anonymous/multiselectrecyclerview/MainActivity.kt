package com.anonymous.multiselectrecyclerview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val items = arrayListOf(
        MyItem("one", randColor()),
        MyItem("two", randColor()),
        MyItem("three", randColor()),
        MyItem("four", randColor()),
        MyItem("five", randColor()),
        MyItem("six", randColor()),
        MyItem("seven", randColor()),
        MyItem("eight", randColor()),
        MyItem("nine", randColor()),
        MyItem("ten", randColor()),
        MyItem("eleven", randColor()),
        MyItem("twelve", randColor())
    )

    private val adapter = MyAdapter(items)

    private fun randColor(): Int {
        val random = Random()
        return Color.argb(
            255,
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.show, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.show -> printAll()
            R.id.remove -> removeSelected()
        }

        return true
    }

    private fun removeSelected() {
        val selected = items.filter { it.selected }
        items.removeAll(selected)
        adapter.notifyDataSetChanged()
    }

    private fun printAll() {
        val text = items
            .filter { it.selected }
            .map { it.text }
            .fold("") { acc, s -> "$acc $s;" }

        AlertDialog.Builder(this)
            .setMessage(text)
            .show()
    }

}
