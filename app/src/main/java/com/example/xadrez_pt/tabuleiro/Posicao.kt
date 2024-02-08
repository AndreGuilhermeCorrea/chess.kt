package com.example.xadrez_pt.tabuleiro

class Posicao {
    private var linha = 0
    private var coluna = 0


    fun getLinha(): Int {
        return linha
    }

    fun setLinha(linha: Int) {
        this.linha = linha
    }

    fun getColuna(): Int {
        return coluna
    }

    fun setColuna(coluna: Int) {
        this.coluna = coluna
    }

    fun setValores(linha: Int, coluna: Int) {
        this.linha = linha
        this.coluna = coluna
    }

    override fun toString(): String {
        return "$linha, $coluna"
    }
}
