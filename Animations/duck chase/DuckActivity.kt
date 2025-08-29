package com.example.animations

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class DuckActivity : AppCompatActivity() {

    private lateinit var duck: ImageView
    private lateinit var worm: ImageView
    private lateinit var rootLayout: RelativeLayout
    private val handler = Handler(Looper.getMainLooper())

    private lateinit var btnChase: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_duck)

        rootLayout = findViewById(R.id.rootLayout)
        worm = findViewById(R.id.duck)
        duck = findViewById(R.id.worm)
        btnChase = findViewById(R.id.btnChase)

        btnChase.setOnClickListener {
            moveWormRandomly()
            startDuckChase()
        }
    }

    private fun moveWormRandomly() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                val maxX = (rootLayout.width - worm.width).toFloat()
                val maxY = (rootLayout.height - worm.height).toFloat()

                val targetX = Random.nextFloat() * maxX
                val targetY = Random.nextFloat() * maxY

                worm.animate()
                    .x(targetX)
                    .y(targetY)
                    .setDuration(1000)
                    .start()

                handler.postDelayed(this, 1500)
            }
        }, 1000)
    }

    private fun startDuckChase() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                val targetX = worm.x
                val targetY = worm.y

                duck.animate()
                    .x(targetX)
                    .y(targetY)
                    .setDuration(1200)
                    .start()

                handler.postDelayed(this, 500)
            }
        }, 500)
    }
}
