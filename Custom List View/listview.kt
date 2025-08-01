package com.example.unit1

import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listview : AppCompatActivity() {

    private lateinit var list: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listview)

//        main file
        list = findViewById(R.id.list);


        val myItems = listOf(
            MyItem("Mobile app Development", "This is an android app", R.drawable.ic_launcher_background),
            MyItem("IOS app Development", "This is an ios app", R.drawable.ic_launcher_foreground),
            MyItem("Web app Development", "This is a web app", R.drawable.ic_launcher_background)

         )

        val adapter = MyAdapter(this, myItems)
        list.adapter = adapter



        list.setOnItemClickListener { parent, view, position, id ->
            val item = myItems[position]
            Toast.makeText(this@listview, "Clicked: ${item.Itemtitle}", Toast.LENGTH_LONG).show()
        }

    }
}