package com.example.unit1

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GridViewMain : AppCompatActivity() {

    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_view_main)

        gridView = findViewById(R.id.gridViewid)

        val items = listOf(
            GridItem("Veggies", "Fresh farm vegetables", "$50/kg", R.drawable.img_4),
            GridItem("Fruits", "Seasonal and tropical fruits", "$80/kg", R.drawable.img_5),
            GridItem("Fish", "Locally sourced fish", "$200/kg", R.drawable.img_6),
            GridItem("Meats", "Fresh chicken and mutton", "$300/kg", R.drawable.img_7),
            GridItem("Dairy", "Milk, cheese, yogurt", "$60/L", R.drawable.img_8),
            GridItem("Spices", "Authentic Indian spices", "$40/100g", R.drawable.img_9)
        )



        val adapter= GridAdapter(this, items)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val item = items[position]
            Toast.makeText(this, "clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }


    }
}