package pt.ulusofuna.cm.kotlin.challenge.models

import pt.ulusofuna.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

abstract class Veiculo (identificador: String): Movimentavel {

    open var identificador = ""
    lateinit var dataDeAquisicao: Date
    lateinit var posicao : Posicao

    abstract fun requerCarta(): Boolean

    override fun toString(): String {
        return "Veiculo | $identificador | $dataDeAquisicao | x:${posicao.x} | y:${posicao.x}"
    }

}
