package com.example.unit3graphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

// ======================
// 🎲 Cube View
// ======================
class CubeView(context: Context) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = 5f

        val startX = 200f
        val startY = 400f
        val size = 300f
        val offset = 100f

        // Front square
        canvas.drawRect(startX, startY, startX + size, startY + size, paint)

        // Back square (offset)
        canvas.drawRect(startX + offset, startY - offset,
            startX + size + offset, startY + size - offset, paint)

        // Connect corners
        canvas.drawLine(startX, startY, startX + offset, startY - offset, paint)
        canvas.drawLine(startX + size, startY, startX + size + offset, startY - offset, paint)
        canvas.drawLine(startX, startY + size, startX + offset, startY + size - offset, paint)
        canvas.drawLine(startX + size, startY + size, startX + size + offset, startY + size - offset, paint)
    }
}


// ======================
// 🎲 Dice Cube View (3D style)
// ======================
class DiceCubeView(context: Context) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.isAntiAlias = true
        paint.strokeWidth = 5f

        val startX = 200f
        val startY = 400f
        val size = 250f
        val offset = 100f

        // --- Faces ---
        // Front face
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawRect(startX, startY, startX + size, startY + size, paint)

        // Top face
        val topPath = android.graphics.Path().apply {
            moveTo(startX, startY)
            lineTo(startX + offset, startY - offset)
            lineTo(startX + size + offset, startY - offset)
            lineTo(startX + size, startY)
            close()
        }
        canvas.drawPath(topPath, paint)

        // Right face
        val rightPath = android.graphics.Path().apply {
            moveTo(startX + size, startY)
            lineTo(startX + size + offset, startY - offset)
            lineTo(startX + size + offset, startY + size - offset)
            lineTo(startX + size, startY + size)
            close()
        }
        canvas.drawPath(rightPath, paint)

        // --- Borders ---
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        canvas.drawRect(startX, startY, startX + size, startY + size, paint)
        canvas.drawPath(topPath, paint)
        canvas.drawPath(rightPath, paint)

        // --- Dots (pips) ---
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        val dotRadius = 15f

        // FRONT face (like number 5)
        val cx = (startX + startX + size) / 2
        val cy = (startY + startY + size) / 2
        canvas.drawCircle(startX + 50, startY + 50, dotRadius, paint)
        canvas.drawCircle(startX + size - 50, startY + 50, dotRadius, paint)
        canvas.drawCircle(startX + 50, startY + size - 50, dotRadius, paint)
        canvas.drawCircle(startX + size - 50, startY + size - 50, dotRadius, paint)
        canvas.drawCircle(cx, cy, dotRadius, paint)

        // TOP face (like number 2)
        canvas.drawCircle(startX + offset + 10, startY - offset + 40, dotRadius, paint)
        canvas.drawCircle(startX + size + offset - 90, startY - offset + 40, dotRadius, paint)

        // RIGHT face (like number 3)
        canvas.drawCircle(startX + size + 54, startY + 60, dotRadius, paint)
        canvas.drawCircle(startX + size + offset -35, startY +10, dotRadius, paint)
        canvas.drawCircle(startX + size + 40, startY + size -100, dotRadius, paint)
    }
}

