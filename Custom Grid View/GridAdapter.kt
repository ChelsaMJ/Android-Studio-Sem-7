package com.example.unit1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet

class GridAdapter (private val context: Context, private val items: List<GridItem>): BaseAdapter()
{
    private val inflater = LayoutInflater.from(context)
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = convertView ?: inflater.inflate(R.layout.grid_item,
            parent,false)

        val imageView = rowView.findViewById<ImageView>(R.id.itemimage)
        val textView = rowView.findViewById<TextView>(R.id.itemtext)
        val textView2 = rowView.findViewById<TextView>(R.id.itemtext2)
        val textView3 = rowView.findViewById<TextView>(R.id.itemtext3)

        val item = getItem(position) as GridItem

        imageView.setImageResource(item.imageResId)
        textView.text = item.name
        textView2.text = item.description
        textView3.text = item.price

        return rowView

    }

}