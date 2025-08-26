package com.example.kotlincoroutine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CompanyAdapter(private val companies: List<Company>) :
    RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.itemimage)
        val nameText: TextView = itemView.findViewById(R.id.itemtext)
        val descText: TextView = itemView.findViewById(R.id.itemtext2)
        val priceText: TextView = itemView.findViewById(R.id.itemtext3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_company_griditem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val company = companies[position]
        holder.imageView.setImageResource(company.imageResId)
        holder.nameText.text = company.name
        holder.descText.text = company.description
        holder.priceText.text = company.price
    }

    override fun getItemCount(): Int = companies.size
}
