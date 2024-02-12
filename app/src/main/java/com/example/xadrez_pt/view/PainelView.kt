package com.example.xadrez_pt.view


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.xadrez_pt.R


@SuppressLint("ClickableViewAccessibility")
class PainelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {



    private val paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.gray)
        textSize = resources.getDimensionPixelSize(R.dimen.text_size).toFloat()
    }

    private var jogador1 = "Jogador 1"
    private var jogador2 = "Jogador 2"
    private var tempoTotal = "Tempo total: 00:00"
    private var tempoJogador1 = "Tempo Jogador 1: 00:00"
    private var tempoJogador2 = "Tempo Jogador 2: 00:00"
    private var pecasCapturadasJogador1 = "Pecas Capturadas Jogador 1: 0"
    private var pecasCapturadasJogador2 = "Pecas Capturadas Jogador 2: 0"

    fun setInfo(jogador1: String, jogador2: String) {
        this.jogador1 = jogador1
        this.jogador2 = jogador2
        invalidate()
    }

    fun setTempoTotal(tempoTotal: String) {
        this.tempoTotal = "Tempo total: $tempoTotal"
        invalidate()
    }

    fun setTempoJogadores(tempoJogador1: String, tempoJogador2: String) {
        this.tempoJogador1 = "Tempo $jogador1: $tempoJogador1"
        this.tempoJogador2 = "Tempo $jogador2: $tempoJogador2"
        invalidate()
    }

    fun setPecasCapturadas(pecasCapturadasJogador1: Int, pecasCapturadasJogador2: Int) {
        this.pecasCapturadasJogador1 = "Pecas Capturadas $jogador1: $pecasCapturadasJogador1"
        this.pecasCapturadasJogador2 = "Pecas Capturadas $jogador2: $pecasCapturadasJogador2"
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val spacing = resources.getDimensionPixelSize(R.dimen.text_spacing).toFloat()

        canvas.drawText(jogador1, spacing, spacing, paint)
        canvas.drawText(jogador2, spacing, 2 * spacing, paint)
        canvas.drawText(tempoTotal, spacing, 3 * spacing, paint)
        canvas.drawText(tempoJogador1, spacing, 4 * spacing, paint)
        canvas.drawText(tempoJogador2, spacing, 5 * spacing, paint)
        canvas.drawText(pecasCapturadasJogador1, spacing, 6 * spacing, paint)
        canvas.drawText(pecasCapturadasJogador2, spacing, 7 * spacing, paint)
    }
}