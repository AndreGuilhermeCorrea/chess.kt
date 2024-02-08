package com.example.xadrez_pt.tabuleiro

abstract class Peca{


    var posicao: Posicao? = null
    private var tabuleiro: Tabuleiro? = null
    open fun Peca(tabuleiro: Tabuleiro?) {
        this.tabuleiro = tabuleiro!!
        posicao = null
    }
    protected open fun getTabuleiro(): Tabuleiro? {
        return tabuleiro
    }

    abstract fun movimentosPossiveis(): Array<BooleanArray>
    fun movimentoPossivel(posicao: Posicao): Boolean {
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()]
    }

    fun umPossivelMovimento(): Boolean {
        val mat = movimentosPossiveis()
        for (i in mat.indices) {
            for (j in mat.indices) {
                if (mat[i][j]) {
                    return true
                }
            }
        }
        return false
    }
}
