package com.example.transitions

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Traffic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic)

        val redOverlay = findViewById<View>(R.id.redOverlay)
        val yellowOverlay = findViewById<View>(R.id.yellowOverlay)
        val greenOverlay = findViewById<View>(R.id.greenOverlay)

        val redBtn = findViewById<Button>(R.id.redBtn)
        val yellowBtn = findViewById<Button>(R.id.yellowBtn)
        val greenBtn = findViewById<Button>(R.id.greenBtn)

        redBtn.setOnClickListener {
            redOverlay.visibility = View.GONE   // remove overlay
            redBtn.visibility = View.GONE       // remove button
        }

        yellowBtn.setOnClickListener {
            yellowOverlay.visibility = View.GONE
            yellowBtn.visibility = View.GONE
        }

        greenBtn.setOnClickListener {
            greenOverlay.visibility = View.GONE
            greenBtn.visibility = View.GONE
        }
    }
}
