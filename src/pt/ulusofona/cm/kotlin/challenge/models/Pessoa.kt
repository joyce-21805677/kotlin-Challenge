package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*
import kotlin.collections.ArrayList

data class Pessoa(var nome: String, var dataDeNascimento: Date): Movimentavel {

    var veiculos = arrayListOf<Veiculo>()
    lateinit var carta: Carta
    var posicao: Posicao = Posicao(0,0)

    fun comprarVeiculo(veiculo: Veiculo) {

        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {

        for (veiculo in veiculos) {
            if (veiculo.identificador == identificador) {
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException("O veiculo não foi encontrado")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {

        var veiculo = pesquisarVeiculo(identificador)

        veiculos.remove(veiculo)

        veiculo.dataDeAquisicao = Date()
        comprador.comprarVeiculo(veiculo)
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {

        var veiculo = pesquisarVeiculo(identificador)

        if (veiculo.requerCarta() && !temCarta()){
            throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
        }else {
            veiculo.moverPara(x, y)
        }
    }

    fun temCarta(): Boolean {

        return this::carta.isInitialized
    }

    fun tirarCarta() {

        if(DateFormatting.getAge(dataDeNascimento) >= 18){
            carta = Carta()
        }else{
            throw MenorDeIdadeException("Pessoa menor de idade tentou tirar carta.")
        }
    }

    override fun moverPara(x: Int, y: Int) {

        if(posicao.x == x && posicao.y == y){
            throw AlterarPosicaoException("Movimento para a posição onde já te encontras.")
        }
        posicao.alterarPosicaoPara(x,y)
    }

    override fun toString(): String {

        return "Pessoa | $nome | ${DateFormatting.getDate(dataDeNascimento)} | $posicao"
    }

}
