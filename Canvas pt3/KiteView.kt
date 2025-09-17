package com.example.transitions

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class KiteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

    private val bodyPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#FFA500") // orange body
    }

    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 4f
        color = Color.BLACK
    }

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 4f
        color = Color.BLACK
    }

    private val bowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.YELLOW
    }

    private val tailPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 6f
        color = Color.WHITE
    }

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.RED
    }

    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val w = width.toFloat()
        val h = height.toFloat()
        val cx = w / 2f
        val cy = h / 3f  // kite sits in upper part

        val halfWidth = w * 0.25f
        val halfHeight = h * 0.20f

        // --- Draw rhombus ---
        path.reset()
        path.moveTo(cx - halfWidth, cy)      // left
        path.lineTo(cx, cy - halfHeight)     // top
        path.lineTo(cx + halfWidth, cy)      // right
        path.lineTo(cx, cy + halfHeight)     // bottom
        path.close()

        canvas.drawPath(path, bodyPaint)
        canvas.drawPath(path, strokePaint)

        // --- Diagonals ---
        canvas.drawLine(cx - halfWidth, cy, cx + halfWidth, cy, linePaint)
        canvas.drawLine(cx, cy - halfHeight, cx, cy + halfHeight, linePaint)

        // --- Side bows (yellow) ---
        val bowSize1 = 100f
        drawBow(canvas, cx - halfWidth, cy, -1, bowSize1) // left
        drawBow(canvas, cx + halfWidth, cy, 1, bowSize1)  // right

        // --- Bottom bow ---
        val bowSize2 = 100f
        drawBottomBow(canvas, cx, cy + halfHeight, bowSize2)


        // --- Slanted thread with circle ---
        val circleX = cx + halfWidth * 1.5f
        val circleY = cy + halfHeight * 2.0f
        canvas.drawLine(cx, cy, circleX, circleY, linePaint)
        canvas.drawCircle(circleX, circleY, 25f, circlePaint)
    }

    private fun drawBow(canvas: Canvas, x: Float, y: Float, dir: Int, size: Float) {
        val bow = Path()
        bow.moveTo(x, y)
        bow.lineTo(x + dir * size, y - size / 2)
        bow.lineTo(x + dir * size, y + size / 2)
        bow.close()
        canvas.drawPath(bow, bowPaint)
    }

    private fun drawBottomBow(canvas: Canvas, x: Float, y: Float, size: Float) {
        val bow = Path()
        bow.moveTo(x, y)
        bow.lineTo(x - size / 2, y + size)
        bow.lineTo(x + size / 2, y + size)
        bow.close()
        canvas.drawPath(bow, bowPaint)
    }
}
