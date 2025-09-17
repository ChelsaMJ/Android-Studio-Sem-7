package com.example.transitions


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


class RhombusView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {


    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#3F51B5") // change as you like
    }


    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 6f
        color = Color.BLACK
    }


    private val path = Path()


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        val w = width.toFloat()
        val h = height.toFloat()
        val cx = w / 2f
        val cy = h / 2f


// These control the rhombus proportions. Adjust the multipliers to change shape.
        val halfWidth = w * 0.25f
        val halfHeight = h * 0.18f


// Build rhombus path (left -> top -> right -> bottom -> close)
        path.reset()
        path.moveTo(cx - halfWidth, cy) // left
        path.lineTo(cx, cy - halfHeight) // top
        path.lineTo(cx + halfWidth, cy) // right
        path.lineTo(cx, cy + halfHeight) // bottom
        path.close()


// Draw fill then stroke
        canvas.drawPath(path, fillPaint)
        canvas.drawPath(path, strokePaint)
    }
}