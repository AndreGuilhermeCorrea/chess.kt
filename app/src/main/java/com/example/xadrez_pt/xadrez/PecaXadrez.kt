package com.example.xadrez_pt.xadrez





abstract class PecaXadrez{

    private var contarMovimentos = 0
    private val cor: Cor? = null

    open fun getCor(): Cor? {
        return cor
    }

    open fun getContarMovimentos(): Int {
        return contarMovimentos
    }

    open fun aumentarContagemMovimentos() {
        contarMovimentos++
    }

    open fun diminuirContagemMovimentos() {
        contarMovimentos--
    }


    open fun getPosicaoXadrez() {

    }


    open fun existePecaOponente(){

    }
}
