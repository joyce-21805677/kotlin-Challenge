package pt.ulusofuna.cm.kotlin.challenge.models

import pt.ulusofuna.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofuna.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofuna.cm.kotlin.challenge.interfaces.Ligavel

class Motor (cavalos: Int, cilindrada: Int): Ligavel {

    var cavalos = 0
    var cilindrada = 0
    var ligado = false

    override fun ligar() {
        if (ligado){
            throw VeiculoLigadoException("Quando uma pessoa tenta ligar um veículo e o mesmo já se encontra ligado.")
        }
        ligado = true
    }

    override fun desligar() {
        if (!ligado){
            throw VeiculoDesligadoException("Quanto uma pessoa tenta desligar um veículo e o mesmo já se encontra desligado.")
        }

        ligado = false
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }
}
