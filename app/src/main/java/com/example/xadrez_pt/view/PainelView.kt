package com.example.xadrez_pt.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.xadrez_pt.R

@SuppressLint("ClickableViewAccessibility")
class PainelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val paint = createDefaultPaint()

    private val jogador1TextView: TextView
    private val jogador2TextView: TextView
    private val tempoJogo: TextView
    private val tempoJogador1: TextView
    private val tempoJogador2: TextView

    private val spacing = resources.getDimensionPixelSize(R.dimen.text_spacing).toFloat()

    init {

        jogador1TextView = createTextView("Jogador 1")
        jogador2TextView = createTextView("Jogador 2")

        tempoJogo= createTextView("Tempo Jogo")
        tempoJogador1= createTextView("Tempo Jogador1")
        tempoJogador2= createTextView("Tempo Jogador2")



        addView(jogador1TextView, createLayoutParams(1))
        addView(jogador2TextView, createLayoutParams(2))
        addView(tempoJogo, createLayoutParams(3))
        addView(tempoJogador1, createLayoutParams(4))
        addView(tempoJogador2, createLayoutParams(5))
    }

    private fun createDefaultPaint(): Paint {
        return Paint().apply {
            color = ContextCompat.getColor(context, R.color.gray)
            textSize = resources.getDimensionPixelSize(R.dimen.text_size).toFloat()
        }
    }

    private fun createTextView(hint: String): TextView {
        val textView = TextView(context)
        applyDefaultTextSettings(textView)
        textView.text = hint
        return textView
    }

    private fun applyDefaultTextSettings(textView: TextView) {
        textView.setTextColor(ContextCompat.getColor(context, R.color.gold))
        textView.textSize = resources.getDimensionPixelSize(R.dimen.text_size).toFloat()
    }

    private fun createLayoutParams(lineNumber: Int): LayoutParams {
        val layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT)
        layoutParams.topMargin  = (lineNumber * spacing).toInt()
        layoutParams.marginStart = spacing.toInt()
        return layoutParams
    }
}