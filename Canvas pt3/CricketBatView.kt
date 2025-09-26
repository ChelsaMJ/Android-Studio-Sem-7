package com.example.transitions


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class CricketBatView(context: Context) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val topY = 500f

        // --- Handle ---
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.color = Color.DKGRAY
        val handleWidth = 80f
        val handleHeight = 250f
        canvas.drawRect(
            centerX - handleWidth / 2,
            topY,
            centerX + handleWidth / 2,
            topY + handleHeight,
            paint
        )

        // --- Blade ---
        paint.color = Color.rgb(245, 222, 179) // light wood color
        val bladeWidth = 300f
        val bladeHeight = 1000f
        val bladeTop = topY + handleHeight
        canvas.drawRect(
            centerX - bladeWidth / 2,
            bladeTop,
            centerX + bladeWidth / 2,
            bladeTop + bladeHeight,
            paint
        )

        // --- Blade curve bottom ---
        val bottomCurve = RectF(
            centerX - bladeWidth / 2,
            bladeTop + bladeHeight - 100f,
            centerX + bladeWidth / 2,
            bladeTop + bladeHeight + 100f
        )
        canvas.drawArc(bottomCurve, 0f, 180f, true, paint)

        // --- Outline for detail ---
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = 6f
        canvas.drawRect(
            centerX - bladeWidth / 2,
            bladeTop,
            centerX + bladeWidth / 2,
            bladeTop + bladeHeight,
            paint
        )
        canvas.drawArc(bottomCurve, 0f, 180f, true, paint)
    }
}
