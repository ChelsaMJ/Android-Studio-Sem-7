package com.example.unit3graphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

// =============================
// ♟️ Chess Board View
// =============================
class ChessBoardView(context: Context) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val boardSize = width.coerceAtMost(height).toFloat()
        val cellSize = boardSize / 8f

        for (row in 0 until 8) {
            for (col in 0 until 8) {
                paint.color = if ((row + col) % 2 == 0) Color.WHITE else Color.BLACK
                val left = col * cellSize
                val top = row * cellSize
                val right = left + cellSize
                val bottom = top + cellSize
                canvas.drawRect(left, top, right, bottom, paint)
            }
        }
    }
}

// =============================
// 🧱 Brick Wall View
// =============================
class BrickWallView(context: Context) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val brickWidth = 200f
        val brickHeight = 100f
        paint.color = Color.RED

        val numRows = (height / brickHeight).toInt() + 2
        val numCols = (width / brickWidth).toInt() + 2

        for (row in 0 until numRows) {
            val offsetX = if (row % 2 == 0) 0f else brickWidth / 2
            for (col in 0 until numCols) {
                val left = col * brickWidth - offsetX
                val top = row * brickHeight
                val right = left + brickWidth
                val bottom = top + brickHeight

                // Red brick
                paint.style = Paint.Style.FILL
                paint.color = Color.RED
                canvas.drawRect(left, top, right, bottom, paint)

                // Black outline
                paint.style = Paint.Style.STROKE
                paint.color = Color.BLACK
                paint.strokeWidth = 4f
                canvas.drawRect(left, top, right, bottom, paint)
            }
        }
    }
}
