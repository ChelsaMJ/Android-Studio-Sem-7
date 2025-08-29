package com.example.animations

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val btnfade = findViewById<Button>(R.id.btnfade)
        val btnmove = findViewById<Button>(R.id.btnmove)

        btnfade.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this, R.anim.move)
            imageView.startAnimation(anim)
        }

        btnmove.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this, R.anim.move)
            imageView.startAnimation(anim)
        }



    }
}