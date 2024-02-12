
    package com.example.xadrez_pt.view

    import android.annotation.SuppressLint
    import android.content.Context
    import android.graphics.Bitmap
    import android.graphics.BitmapFactory
    import android.graphics.Canvas
    import android.graphics.Paint
    import android.graphics.RectF
    import android.util.AttributeSet
    import android.view.View
    import androidx.core.content.ContextCompat
    import com.example.xadrez_pt.R

    @SuppressLint("ClickableViewAccessibility")
    class TabuleiroView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : View(context, attrs, defStyleAttr) {

        // Define o tamanho da View
        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            // Calcula o tamanho exato da View com base no tamanho do tabuleiro
            val tabuleiroSize = (8 * (medidaLadrilho + margemLadrilho)).toInt()
            setMeasuredDimension(tabuleiroSize, tabuleiroSize)
        }

        private val paint = Paint()

        private val medidaLadrilho = resources.getDimensionPixelSize(R.dimen.medidaLadrilho).toFloat()
        private val margemLadrilho = resources.getDimensionPixelSize(R.dimen.margemLadrilho).toFloat()

        private val ladrilhoDark = ContextCompat.getColor(context, R.color.gray)
        private val ladrilhoLight = ContextCompat.getColor(context, R.color.white)
        private var isLadrilhoDark: Boolean = false



        private val bitmaps = mutableMapOf<Int, Bitmap>()

        private val pecaID = setOf(
            R.drawable.bp,
            R.drawable.bb,
            R.drawable.kp,
            R.drawable.kb,
            R.drawable.qp,
            R.drawable.qb,
            R.drawable.tp,
            R.drawable.tb,
            R.drawable.cp,
            R.drawable.cb,
            R.drawable.pp,
            R.drawable.pb,
        )

        init {
            carregaPecas()
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            drawTabuleiro(canvas)
            drawPecas(canvas)
        }
        private fun drawTabuleiro(canvas: Canvas) {
            for (row in 0 until 8) {
                for (col in 0 until 8) {
                    isLadrilhoDark = (col + row) % 2 == 1
                    paint.color = if (isLadrilhoDark) ladrilhoDark else ladrilhoLight
                    canvas.drawRect(
                        col * (medidaLadrilho + margemLadrilho),
                        row * (medidaLadrilho + margemLadrilho),
                        (col + 1) * (medidaLadrilho + margemLadrilho) - margemLadrilho,
                        (row + 1) * (medidaLadrilho + margemLadrilho) - margemLadrilho,
                        paint
                    )
                }
            }
        }
        private fun drawPecas(canvas: Canvas) {
            drawPecasAt(canvas, 0, 0, R.drawable.tb)
            drawPecasAt(canvas, 1, 0, R.drawable.cb)
            drawPecasAt(canvas, 2, 0, R.drawable.bb)
            drawPecasAt(canvas, 3, 0, R.drawable.qb)
            drawPecasAt(canvas, 4, 0, R.drawable.kb)
            drawPecasAt(canvas, 5, 0, R.drawable.bb)
            drawPecasAt(canvas, 6, 0, R.drawable.cb)
            drawPecasAt(canvas, 7, 0, R.drawable.tb)
            drawPecasAt(canvas, 0, 1, R.drawable.pb)
            drawPecasAt(canvas, 1, 1, R.drawable.pb)
            drawPecasAt(canvas, 2, 1, R.drawable.pb)
            drawPecasAt(canvas, 3, 1, R.drawable.pb)
            drawPecasAt(canvas, 4, 1, R.drawable.pb)
            drawPecasAt(canvas, 5, 1, R.drawable.pb)
            drawPecasAt(canvas, 6, 1, R.drawable.pb)
            drawPecasAt(canvas, 7, 1, R.drawable.pb)

            drawPecasAt(canvas, 0, 6, R.drawable.pp)
            drawPecasAt(canvas, 1, 6, R.drawable.pp)
            drawPecasAt(canvas, 2, 6, R.drawable.pp)
            drawPecasAt(canvas, 3, 6, R.drawable.pp)
            drawPecasAt(canvas, 4, 6, R.drawable.pp)
            drawPecasAt(canvas, 5, 6, R.drawable.pp)
            drawPecasAt(canvas, 6, 6, R.drawable.pp)
            drawPecasAt(canvas, 7, 6, R.drawable.pp)
            drawPecasAt(canvas, 0, 7, R.drawable.tp)
            drawPecasAt(canvas, 1, 7, R.drawable.cp)
            drawPecasAt(canvas, 2, 7, R.drawable.bp)
            drawPecasAt(canvas, 3, 7, R.drawable.qp)
            drawPecasAt(canvas, 4, 7, R.drawable.kp)
            drawPecasAt(canvas, 5, 7, R.drawable.pp)
            drawPecasAt(canvas, 6, 7, R.drawable.cp)
            drawPecasAt(canvas, 7, 7, R.drawable.tp)
        }



        private fun carregaPecas(){
            pecaID.forEach{
                bitmaps[it] = BitmapFactory.decodeResource(resources, it)
            }
        }




        private fun drawPecasAt(canvas: Canvas, col: Int, row: Int, pecaID: Int){

            val left = margemLadrilho + col * (medidaLadrilho + margemLadrilho)
            val top = margemLadrilho + (7 - row) * (medidaLadrilho + margemLadrilho)
            val right = left + medidaLadrilho
            val bottom = top + medidaLadrilho

            // Ajusta o fator de escala da peça
            val scaleFactor = 0.85f
            val scaledWidth = medidaLadrilho * scaleFactor
            val scaledHeight = medidaLadrilho * scaleFactor

            // Calcula as coordenadas para centralizar a peça no ladrilho
            val centerX = (left + right - scaledWidth) / 2
            val centerY = (top + bottom - scaledHeight) / 2

            canvas.drawBitmap(
                bitmaps[pecaID]!!,
                null,
                RectF(centerX, centerY, centerX + scaledWidth, centerY + scaledHeight),
                paint
            )
        }





    }
