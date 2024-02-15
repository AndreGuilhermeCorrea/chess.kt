package com.example.xadrez_pt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.xadrez_pt.controller.TabuleiroActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onPlayGameClick(view: View) {
        val jogador1Nome = findViewById<EditText>(R.id.jogador1TextView).text.toString()
        val jogador2Nome = findViewById<EditText>(R.id.jogador2TextView).text.toString()

        val intent = Intent(this, TabuleiroActivity::class.java).apply {
            putExtra("jogador1Nome", jogador1Nome)
            putExtra("jogador2Nome", jogador2Nome)
        }

        startActivity(intent)
    }

}