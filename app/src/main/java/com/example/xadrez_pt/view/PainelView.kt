package com.example.xadrez_pt.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.os.CountDownTimer
import android.util.AttributeSet
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.xadrez_pt.R
import java.util.concurrent.TimeUnit

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

    private var tempoJogoAtual: Long = 0
    private var tempoJogador1Atual: Long = 0
    private var tempoJogador2Atual: Long = 0

    private val spacing = resources.getDimensionPixelSize(R.dimen.text_spacing).toFloat()




    init {

        jogador1TextView = createTextView("")
        jogador2TextView = createTextView("")

        tempoJogo= createTextView("Tempo Jogo")
        tempoJogador1= createTextView("Tempo Jogador1")
        tempoJogador2= createTextView("Tempo Jogador2")



        addView(jogador1TextView, createLayoutParams(1))
        addView(jogador2TextView, createLayoutParams(2))
        addView(tempoJogo, createLayoutParams(3))
        addView(tempoJogador1, createLayoutParams(4))
        addView(tempoJogador2, createLayoutParams(5))
    }


    fun iniciarJogo() {
        val countUpTimer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tempoJogoAtual += 1000
                tempoJogo.text = "Tempo Jogo: ${formatarTempo(tempoJogoAtual)}"
            }

            override fun onFinish() {

            }
        }

        countUpTimer.start()
    }


    private fun formatarTempo(tempo: Long): String {
        val horas = TimeUnit.MILLISECONDS.toHours(tempo)
        val minutos = TimeUnit.MILLISECONDS.toMinutes(tempo)
        val segundos = TimeUnit.MILLISECONDS.toSeconds(tempo) -
                TimeUnit.MINUTES.toSeconds(minutos)
        return String.format("%02d:%02d:%02d", horas, minutos, segundos)
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

    fun setJogador1Nome(jogador1Nome: String) {
        jogador1TextView.text = "Jogador 1: $jogador1Nome"
    }

    fun setJogador2Nome(jogador2Nome: String) {
        jogador2TextView.text = "Jogador 2: $jogador2Nome"
    }
}