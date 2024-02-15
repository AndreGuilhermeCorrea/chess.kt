package com.example.xadrez_pt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.xadrez_pt.controller.TabuleiroActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onPlayGameClick(view: View) {
        // Inicia a TabuleiroActivity
        val intent = Intent(this, TabuleiroActivity::class.java)
        startActivity(intent)
    }

}