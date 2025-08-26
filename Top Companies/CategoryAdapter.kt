package com.example.kotlincoroutine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CategoryAdapter(private val context: Context, private val categories: List<Category>) :
    BaseAdapter() {

    override fun getCount(): Int = categories.size
    override fun getItem(position: Int): Any = categories[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.top_company_listitem, parent, false)

        val image = view.findViewById<ImageView>(R.id.img)
        val title = view.findViewById<TextView>(R.id.txt1)
        val subtitle = view.findViewById<TextView>(R.id.txt2)

        val category = categories[position]
        image.setImageResource(category.imageResId)
        title.text = category.title
        subtitle.text = category.subtitle

        return view
    }
}
