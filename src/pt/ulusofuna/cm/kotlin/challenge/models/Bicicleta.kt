package pt.ulusofuna.cm.kotlin.challenge.models

class Bicicleta(identificador: String): Veiculo(identificador) {


    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x,y)
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | ${dataDeAquisicao} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }
}