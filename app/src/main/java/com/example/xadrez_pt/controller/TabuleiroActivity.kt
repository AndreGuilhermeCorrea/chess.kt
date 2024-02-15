package com.example.xadrez_pt.controller

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.xadrez_pt.R
import com.example.xadrez_pt.view.PainelView
import com.example.xadrez_pt.view.TabuleiroView

class TabuleiroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuleiro)

        val tabuleiroContainer = findViewById<FrameLayout>(R.id.tabuleiroContainer)

        val painelContainer = findViewById<FrameLayout>(R.id.painelContainer)

        // Inflando a TabuleiroView e adicionando ao contêiner
        val tabuleiroView = TabuleiroView(this)
        tabuleiroContainer.addView(tabuleiroView)

        // Inflando a painelView e adicionando ao contêiner
        val painelView = PainelView(this)
        painelContainer.addView(painelView)


        // Recebe os dados da MainActivity
        val jogador1Nome = intent.getStringExtra("jogador1Nome") ?: "Jogador 1"
        val jogador2Nome = intent.getStringExtra("jogador2Nome") ?: "Jogador 2"


        painelView.setJogador1Nome(jogador1Nome)
        painelView.setJogador2Nome(jogador2Nome)
    }
}
