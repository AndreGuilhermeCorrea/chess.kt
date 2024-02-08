package com.example.xadrez_pt.tabuleiro

class Tabuleiro {
    private var linhas = 0
    private var colunas = 0

    private lateinit var pecas: Array<Array<Peca?>>


    fun getLinhas(): Int {
        return linhas
    }

    fun getColunas(): Int {
        return colunas
    }

    fun peca(linha: Int, coluna: Int): Peca? {
        return pecas[linha][coluna]
    }

    fun peca(posicao: Posicao): Peca? {
        return pecas[posicao.getLinha()][posicao.getColuna()]
    }

    fun localPeca(peca: Peca, posicao: Posicao) {
        pecas[posicao.getLinha()][posicao.getColuna()] = peca
        peca.posicao = posicao
    }

    fun removePeca(posicao: Posicao): Peca? {
        if (peca(posicao) == null) {
            return null
        }
        val aux = peca(posicao)
        aux!!.posicao = null
        pecas[posicao.getLinha()][posicao.getColuna()] = null
        return aux
    }

    private fun isPosicaoOcupada(linha: Int, coluna: Int): Boolean {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas
    }

    fun isPosicaoVazia(posicao: Posicao): Boolean {
        return isPosicaoOcupada(posicao.getLinha(), posicao.getColuna())
    }

    fun pecaNaPosicao(posicao: Posicao): Boolean {
        return peca(posicao) != null
    }

    fun limparTabuleiro() {
        for (i in 0 until linhas) {
            for (j in 0 until colunas) {
                pecas[i][j] = null
            }
        }
    }

}
