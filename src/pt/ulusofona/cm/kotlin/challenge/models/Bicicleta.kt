package pt.ulusofona.cm.kotlin.challenge.models

import java.time.format.DateTimeFormatter
import java.util.*

class Bicicleta(identificador: String): Veiculo(identificador) {


    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x,y)
    }

    override fun toString(): String {

        return "Bicicleta | $identificador | ${dataDeAquisicao.format(DateTimeFormatter.ofPattern("DD-MM-YYY"))} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }
}
