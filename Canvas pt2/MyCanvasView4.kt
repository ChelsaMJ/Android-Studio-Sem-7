import android.R.attr.width
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

// ======================
// 🥛 Glass of Water View
// ======================
class GlassOfWaterView(context: Context) : View(context) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val topY = 200f
        val glassWidth = 300f
        val glassHeight = 500f
        val radiusX = glassWidth / 2
        val radiusY = 40f

        // --- Glass outline ---
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 6f
        paint.color = Color.GRAY

        // Top oval
        val topOval = android.graphics.RectF(centerX - radiusX, topY - radiusY, centerX + radiusX, topY + radiusY)
        canvas.drawOval(topOval, paint)

        // Body (two side lines)
        canvas.drawLine(centerX - radiusX, topY, centerX - radiusX, topY + glassHeight, paint)
        canvas.drawLine(centerX + radiusX, topY, centerX + radiusX, topY + glassHeight, paint)

        // Bottom oval
        val bottomOval = android.graphics.RectF(centerX - radiusX, topY + glassHeight - radiusY, centerX + radiusX, topY + glassHeight + radiusY)
        canvas.drawOval(bottomOval, paint)


        // --- Water fill ---
        paint.style = Paint.Style.FILL
        paint.color = Color.argb(180, 0, 150, 255) // semi-transparent blue
        val waterLevel = topY + glassHeight * 0.6f
        val waterRect = android.graphics.RectF(centerX - radiusX + 4, waterLevel, centerX + radiusX - 4, topY + glassHeight)
        canvas.drawRect(waterRect, paint)



        // Water surface (oval)
        val waterOval = android.graphics.RectF(centerX - radiusX + 4, waterLevel - radiusY, centerX + radiusX - 4, waterLevel + radiusY)
        canvas.drawOval(waterOval, paint)

        // Fill bottom oval (water base)
        val waterBottom = android.graphics.RectF(centerX - radiusX + 4, topY + glassHeight - radiusY,
            centerX + radiusX - 4, topY + glassHeight + radiusY)
        canvas.drawOval(waterBottom, paint)

        // --- Glass shine/reflection ---
        paint.color = Color.argb(100, 255, 255, 255)
        canvas.drawRect(centerX - radiusX + 20, topY + 50, centerX - radiusX + 40, topY + glassHeight - 50, paint)
    }
}
