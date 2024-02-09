package com.example.xadrez_pt.xadrez

class PosicaoXadrez{

    private var coluna = 0.toChar()
    private var linha = 0


    protected fun dePosicao() {

    }

    @Override
    override fun toString(): String {
        return "" + coluna + linha
    }


}
