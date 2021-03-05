package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*


abstract class Veiculo (var identificador: String): Movimentavel {

    var dataDeAquisicao: Date = Date()
    var posicao : Posicao = Posicao(0,0)

    abstract override fun moverPara(x: Int, y: Int)

    abstract fun requerCarta(): Boolean

    override fun toString(): String {
        return "Veiculo | $identificador | ${DateFormatting.getDate(dataDeAquisicao)} | x:${posicao.x} | y:${posicao.x}"
    }

}
