package pt.ulusofuna.cm.kotlin.challenge.models

import pt.ulusofuna.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofuna.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.util.*
import kotlin.collections.ArrayList

class Pessoa(var nome: String, var dataDeNascimento: Date) {
    lateinit var veiculos: ArrayList<Veiculo>
    lateinit var carta: Carta
    lateinit var posicao: Posicao

    fun comprarVeiculo(veiculo: Veiculo) {

        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo{


        for (veiculo in veiculos) {
            if (identificador == veiculo.identificador) {
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

    fun moverVeiculo(identificador: String, x: Int, y: Int) {
        var veiculo = pesquisarVeiculo(identificador)

        if (veiculo.requerCarta() && !temCarta()){
            throw PessoaSemCartaException("Quanto uma pessoa sem carta tenta conduzir um veículo que necessita de carta.")
        }else {
            veiculo.moverPara(x, y)
        }
    }

    fun temCarta(): Boolean {

        return false
    }

    fun tirarCarta() {

    }

    override fun toString(): String {
        //TODO(Formatação de data) var formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy")
        // var formattedDate = date.format(formatter)
        return "Pessoa | $nome | $veiculos | $dataDeNascimento | $carta | ${posicao.x} | ${posicao.y}"
    }

}
