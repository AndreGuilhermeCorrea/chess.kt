package com.example.xadrez_pt.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.example.xadrez_pt.R


@SuppressLint("ClickableViewAccessibility")
class PainelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.gray)
        textSize = resources.getDimensionPixelSize(R.dimen.text_size).toFloat()
    }

    private val jogador1EditText: EditText
    private val jogador2EditText: EditText

    init {
        jogador1EditText = EditText(context)
        jogador1EditText.layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        jogador1EditText.hint = "Jogador 1"
        jogador1EditText.setTextColor(ContextCompat.getColor(context, R.color.gray_light))
        jogador1EditText.textSize = resources.getDimensionPixelSize(R.dimen.text_size).toFloat()
        addView(jogador1EditText)

        jogador2EditText = EditText(context)
        jogador2EditText.layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        jogador2EditText.hint = "Jogador 2"
        jogador2EditText.setTextColor(ContextCompat.getColor(context, R.color.gray_light))
        jogador2EditText.textSize = resources.getDimensionPixelSize(R.dimen.text_size).toFloat()
        addView(jogador2EditText)
    }

    fun setInfo(jogador1: String, jogador2: String) {
        jogador1EditText.setText(jogador1)
        jogador2EditText.setText(jogador2)
        invalidate()
    }

    fun setTempoTotal(tempoTotal: String) {
        // Lógica para atualizar tempo total
        invalidate()
    }

    fun setTempoJogadores(tempoJogador1: String, tempoJogador2: String) {
        // Lógica para atualizar tempos dos jogadores
        invalidate()
    }

    fun setPecasCapturadas(pecasCapturadasJogador1: Int, pecasCapturadasJogador2: Int) {
        // Lógica para atualizar peças capturadas
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val spacing = resources.getDimensionPixelSize(R.dimen.text_spacing).toFloat()

        val textLines = listOf(
            "Jogador 1: ${jogador1EditText.text}",
            "Jogador 2: ${jogador2EditText.text}",
            "Tempo total: 00:00", // Adicione lógica para obter o tempo total
            "Tempo Jogador 1: 00:00", // Adicione lógica para obter o tempo do jogador 1
            "Tempo Jogador 2: 00:00", // Adicione lógica para obter o tempo do jogador 2
            "Pecas Capturadas Jogador 1: 0", // Adicione lógica para obter peças capturadas do jogador 1
            "Pecas Capturadas Jogador 2: 0"  // Adicione lógica para obter peças capturadas do jogador 2
        )

        for ((index, text) in textLines.withIndex()) {
            canvas.drawText(text, spacing, (index + 1) * spacing, paint)
        }
    }
}