import kotlin.math.pow

class Persona(var peso: Float, var altura: Float) {
    var nombre: String = ""
        get() = field
        set(value){
            require(value.isNotEmpty()) {"El nombre no puede estar vacío"}
            field = value
        }
    constructor(nombre: String, peso: Float, altura: Float) : this(peso,altura){
        this.nombre = nombre
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if (other !is Persona) return false
        return nombre == other.nombre && altura == other.altura
    }

    override fun hashCode(): Int {
        return 31 * nombre.hashCode() + peso.hashCode() + altura.hashCode()
    }

    fun calcular_imc(): Float{
        val imc = peso * altura.pow(2)
        return imc
    }

    override fun toString(): String {
        return "Persona: $nombre, peso: $peso, altura: $altura"
    }


}






fun mostrar_personas(persona1: Persona, persona2: Persona, persona3: Persona, modificacion: Boolean){
    if(!modificacion){
        println(persona1)
        println(persona2)
        println("$persona3, ${persona3.calcular_imc()}")
    }else{
        println(persona1)
        println("$persona3, ${persona3.calcular_imc()}")
        println("$persona2,${persona2.calcular_imc()}")
        if(persona1 == persona2){
            println("Son iguales")
        }else{
            println("No son iguales")
        }

    }

}

fun mostrar_error(msj: String){
    println(msj)
}


fun pedir_nombre(persona: Persona,msj: String): String{
    var nombre_correcto = false
    var nombre = ""
    while(!nombre_correcto){
        try {
            println(msj)
            nombre = readln()
            persona.nombre = nombre
            nombre_correcto = true
        }catch(e: IllegalArgumentException){
            mostrar_error("$e")
        }
    }
    return nombre
}

fun modificar_propiedades(persona1: Persona,persona2: Persona,persona3: Persona){
    persona1.nombre = pedir_nombre(persona1,"Introduce un nombre para la persona1, no puede estar vacío.")
    persona3.altura = 1.90F
    persona2.altura = persona3.altura
}

fun main(){
    var persona1 = Persona(peso = 55F, altura = 1.20F)
    var persona2 = Persona(nombre = "Juan", peso = 70F, altura = 1.75F)
    var persona3 = Persona(nombre = "María", peso = 90F, altura = 1.80F)

    mostrar_personas(persona1,persona2,persona3, modificacion = false)

    modificar_propiedades(persona1,persona2,persona3)


    mostrar_personas(persona1,persona2,persona3, modificacion = true)


}