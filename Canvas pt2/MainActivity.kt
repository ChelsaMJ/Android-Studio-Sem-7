package com.example.unit3graphics

import GlassOfWaterView
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(MyCanvasView(this))
        setContentView(BrickWallView(this))
        setContentView(ChessBoardView(this))
        setContentView(CubeView(this))
        setContentView(DiceCubeView(this))
        setContentView(GlassOfWaterView(this))




    }
}
