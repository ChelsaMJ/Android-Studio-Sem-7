package com.example.transitions

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlin.math.min
import kotlin.math.sqrt

class RectangleCircleView(context: Context) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        paint.isAntiAlias = true

        // --- Square dimensions ---
        val padding = 100f
        val side = min(width, height) - 2 * padding
        val left = (width - side) / 2
        val top = (height - side) / 2
        val right = left + side
        val bottom = top + side

        // Draw square
        canvas.drawRect(left, top, right, bottom, paint)

        // --- Circle in center ---
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = side / 4f
        canvas.drawCircle(centerX, centerY, radius, paint)

        // --- Lines from corners to circle ---
        val offset = radius / sqrt(2f) // offset for 45° angle

        // Top-left → circle
        canvas.drawLine(left, top, centerX - offset, centerY - offset, paint)
        // Top-right → circle
        canvas.drawLine(right, top, centerX + offset, centerY - offset, paint)
        // Bottom-left → circle
        canvas.drawLine(left, bottom, centerX - offset, centerY + offset, paint)
        // Bottom-right → circle
        canvas.drawLine(right, bottom, centerX + offset, centerY + offset, paint)
    }
}
