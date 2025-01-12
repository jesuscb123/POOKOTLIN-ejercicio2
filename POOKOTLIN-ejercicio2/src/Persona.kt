import kotlin.math.pow

class Persona(var peso: Float, var altura: Float) {
    var nombre: String = ""
    constructor(nombre: String, peso: Float, altura: Float) : this(peso,altura){
        this.nombre = nombre
    }

    fun calcular_imc(): String{
        val imc = peso * altura.pow(2)
        return "índice de masa corporal: $imc"
    }

    override fun toString(): String {
        return "Persona: $nombre, peso: $peso, altura: $altura"
    }
}



