package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.util.*


abstract class Veiculo (identificador: String): Movimentavel {

    open var identificador = ""
    var dataDeAquisicao: Date = Date()
    var posicao : Posicao = Posicao(0,0)

    abstract fun requerCarta(): Boolean

    override fun toString(): String {
        return "Veiculo | $identificador | ${DateFormatting.getDate(dataDeAquisicao)} | x:${posicao.x} | y:${posicao.x}"
    }

}
