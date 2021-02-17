package pt.ulusofuna.cm.kotlin.challenge.models

class Carro (identificador: String, motor: Motor): Veiculo(identificador){

    override fun requerCarta(): Boolean {
        return true
    }

    lateinit var motor : Motor

    override fun toString(): String {
        return "Carro | $identificador | $motor"
    }
}
