package com.example.xadrez_pt.controller

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.xadrez_pt.R
import com.example.xadrez_pt.view.TabuleiroView

class TabuleiroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabuleiro)

        val tabuleiroContainer = findViewById<FrameLayout>(R.id.tabuleiroContainer)

        // Inflando a TabuleiroView e adicionando ao contêiner
        val tabuleiroView = TabuleiroView(this)
        tabuleiroContainer.addView(tabuleiroView)
    }
}
