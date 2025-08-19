package com.example.kotlincoroutine

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val resulttext = findViewById<TextView>(R.id.resultText)
        val btnFetch = findViewById<Button>(R.id.btnFetch)

        viewModel.result.observe(this, Observer{
            resulttext.text =it
        })

        btnFetch.setOnClickListener {
            viewModel.startWork()
        }



    }
}