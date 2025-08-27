package com.example.unit3graphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyCanvasView(context: Context) : View(context) {

    private val paint: Paint = Paint()

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)

        paint.color = Color.BLUE
        paint.strokeWidth = 10f

//        line
        canvas.drawLine(100f, 100f, 500f,500f,paint)

//        circle
        paint.color = Color.RED
        canvas.drawCircle(300f,300f,100f,paint)

//        rectangle
        paint.color = Color.GREEN
        canvas.drawRect(100f,600f,500f,800f,paint)

//        text
        paint.color= Color.BLACK
        paint.textSize = 60f
        canvas.drawText("Hello Canvas!", 100f, 900f, paint)


    }
}