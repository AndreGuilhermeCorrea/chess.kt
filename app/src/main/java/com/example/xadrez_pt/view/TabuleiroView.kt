package com.example.xadrez_pt.view

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.xadrez_pt.R

class TabuleiroView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private var selecionaLadrilho: Pair<Int, Int>? = null
    private val tamanhoPeca = 100f
    private val margemPeca = 10f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawTabuleiro(canvas)
        drawPecas(canvas)
    }

    private fun drawPecas(canvas: Canvas) {

        if (selecionaLadrilho != null) {
            val col = selecionaLadrilho!!.first
            val row = selecionaLadrilho!!.second

            val pieceBitmap = BitmapFactory.decodeResource(resources, R.drawable.bb)
            val left = col * (tamanhoPeca + margemPeca)
            val top = row * (tamanhoPeca + margemPeca)
            canvas.drawBitmap(pieceBitmap, left, top, paint)
        }
    }

    private fun drawTabuleiro(canvas: Canvas) {

        val ladrilhoDark = Color.DKGRAY
        val ladrilhoLight = Color.LTGRAY
        var isLadrilhoDark: Boolean


        for (row in 0 until 8) {
            for (col in 0 until 8) {
                isLadrilhoDark = (col + row) % 2 == 1
                paint.color = if (isLadrilhoDark) ladrilhoDark else ladrilhoLight

                canvas.drawRect(
                    col * (tamanhoPeca + margemPeca),
                    row * (tamanhoPeca + margemPeca),
                    (col + 1) * (tamanhoPeca + margemPeca) - margemPeca,
                    (row + 1) * (tamanhoPeca + margemPeca) - margemPeca,
                    paint)
            }
        }
    }
}