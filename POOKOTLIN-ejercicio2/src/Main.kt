


/*
Crear una clase Persona que tenga nombre, peso (en kg con decimales), altura (en metros con decimales) y su imc.

Crear un constructor primario con todos los atributos, excepto nombre e imc. Este último atributo se calcula en función del peso y la altura. Por tanto no se debe poder modificar, pero si consultar.

Crear un constructor secundario que también incluya el nombre de la persona cómo parámetro.

Implementa el método toString, representación del objeto en forma de String: override fun toString() = "". (Pulsa Ctrl+o)

En el main(), crear 3 personas diferentes (la primera sin nombre) utilizando el constructor primario y secundario. Después mostrarlas por consola y a continuación, realizar lo siguiente:

Sobre la persona 1: Modificar su nombre y para ello debes solicitarlo al usuario por consola. No puede ser nulo o vacio. Mostrar por consola sólo el nombre, peso y altura. Sobre la persona 3: Mostrar el peso, altura y imc. Modificar la altura, por ejemplo a 1.80 Mostrar el peso, altura y imc. Sobre la persona 2: Modificar la altura para que tenga el mismo valor que la persona 3. Mostrar la persona 2 y persona 3. Comparar si las dos personas son iguales, y mostrar el resultado. Implementa el método equals():boolean (Pulsa Ctrl+o). Ejecutar la comparación.
 */





fun mostrar_personas(persona1: Persona, persona2: Persona, persona3: Persona){
    println("$persona1, ${persona1.calcular_imc()}")
    println("$persona2, ${persona2.calcular_imc()}")
    println("$persona3, ${persona3.calcular_imc()}")
}

fun mostrar_error(msj: String){
    println(msj)
}

fun comprobar_nombre_correcto(nombre: String): Boolean{
    if(nombre == ""){
        return false
    }
    return true
}

fun pedir_nombre(msj: String): String{
    var nombre_correcto = false
    var nombre = ""
    while(!nombre_correcto){
        try {
            println(msj)
            nombre = readln()
            if(!comprobar_nombre_correcto(nombre)) {
                throw IllegalArgumentException("**Error** el nombre no puede estar vacío.")
            }else{
                nombre_correcto = true
            }

        }catch(e: IllegalArgumentException){
            mostrar_error("$e")
        }
    }
    return nombre
}

fun modificar_propiedades(persona1: Persona,persona2: Persona,persona3: Persona){
    persona1.nombre = pedir_nombre("Introduce un nombre para la persona1, no puede estar vacío.")
    persona3.altura = 1.90F
    persona2.altura = persona3.altura
}

fun main(){
    var persona1 = Persona(peso = 55F, altura = 1.20F)
    var persona2 = Persona(nombre = "Juan", peso = 70F, altura = 1.75F)
    var persona3 = Persona(nombre = "María", peso = 90F, altura = 1.80F)
    mostrar_personas(persona1,persona2,persona3)
    modificar_propiedades(persona1,persona2,persona3)
    

    mostrar_personas(persona1,persona2,persona3)


}