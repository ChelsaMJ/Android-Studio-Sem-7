package com.example.kotlincoroutine

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class TopCompany : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top_company_main)

        val listView = findViewById<ListView>(R.id.listView)

        val categories = listOf(
            Category("Android Company", "Top Android makers", R.drawable.ic_launcher_background),
            Category("iOS Company", "Top iOS related firms", R.drawable.ic_launcher_foreground),
            Category("React Company", "React-based companies", R.drawable.ic_launcher_background),
            Category("Full Stack", "End-to-end companies", R.drawable.ic_launcher_foreground)
        )

        val adapter = CategoryAdapter(this, categories)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, TopCompanyGrid::class.java)
            intent.putExtra("category", categories[position].title)
            startActivity(intent)
        }
    }
}
