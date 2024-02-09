package com.example.xadrez_pt.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TabuleiroView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawChessboard(canvas)
    }
    private fun drawChessboard(canvas: Canvas) {
        val squareSize = width / 8

        for (row in 0 until 8) {
            for (col in 0 until 8) {
                val isDarkSquare = (col + row) % 2 == 1
                val backgroundColor = if (isDarkSquare) Color.DKGRAY else Color.LTGRAY

                paint.color = backgroundColor
                canvas.drawRect(col * squareSize.toFloat(), row * squareSize.toFloat(),
                    (col + 1) * squareSize.toFloat(), (row + 1) * squareSize.toFloat(), paint)
            }
        }
    }
}