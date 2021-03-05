package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Bicicleta(identificador: String): Veiculo(identificador) {


    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        if (posicao.x == x && posicao.y == y){
            throw AlterarPosicaoException("Movimento para a posição onde já te encontras.")
        }
        posicao.alterarPosicaoPara(x,y)
    }

    override fun toString(): String {

        return "Bicicleta | $identificador | ${DateFormatting.getDate(dataDeAquisicao)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }
}
