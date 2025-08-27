package com.example.unit3graphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class MyCanvasView(context: Context) : View(context) {

    private val paint: Paint = Paint()

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)

        paint.color = Color.BLUE
        paint.strokeWidth = 10f

        // line
        canvas.drawLine(100f, 100f, 500f,500f,paint)

        // circle
        paint.color = Color.RED
        canvas.drawCircle(300f,300f,100f,paint)

        // rectangle
        paint.color = Color.GREEN
        canvas.drawRect(100f,600f,500f,800f,paint)

        // text
        paint.color= Color.BLACK
        paint.textSize = 60f
        canvas.drawText("Hello Canvas!", 100f, 900f, paint)

        // ==========================
        // 😀 Smiley Face Drawing
        // ==========================
        // Face
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL
        canvas.drawCircle(500f, 1500f, 300f, paint)

        // Eyes
        paint.color = Color.BLACK
        canvas.drawCircle(400f, 1400f, 40f, paint) // Left eye
        canvas.drawCircle(600f, 1400f, 40f, paint) // Right eye

        // Smile (arc)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 15f
        val mouthRect = RectF(350f, 1450f, 650f, 1650f)
        canvas.drawArc(mouthRect, 0f, 180f, false, paint)


        // ==========================
        // 🛰️ Satellite Below Smiley
        // ==========================
        paint.color = Color.BLUE
        paint.strokeWidth = 10f

        // Shifted line down
        canvas.drawLine(300f, 2200f, 700f, 2600f, paint)

        // Circle in middle of line
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        canvas.drawCircle(500f, 2400f, 100f, paint)

        // Rectangles (diamonds) at both ends
        paint.color = Color.GRAY
        paint.style = Paint.Style.FILL
        val rectSize = 300f

        val points = listOf(
            Pair(300f, 2200f),  // start of line
            Pair(700f, 2600f)   // end of line
        )

        for ((x, y) in points) {
            val left = x - rectSize / 2
            val top = y - rectSize / 2
            val right = x + rectSize / 2
            val bottom = y + rectSize / 2

            canvas.save()
            canvas.rotate(45f, x, y) // diamond effect
            canvas.drawRect(left, top, right, bottom, paint)
            canvas.restore()
        }
    }
}
