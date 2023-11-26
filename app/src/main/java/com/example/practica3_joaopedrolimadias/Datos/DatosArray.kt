package com.example.practica3_joaopedrolimadias.Datos

import org.intellij.lang.annotations.JdkConstants.BoxLayoutAxis

var ArrayBox = ArrayList<DatosJugador>()

class DatosArray() {
    val opcionesJugador = arrayListOf(
        "Messi",
        "Cristiano",
        "Griezman",
        "Mbappe",
        "Halaand",
        "Modric",
        "Pedri",
        "Gavi",
        "Musiala",
        "Saka"
    )
    val opcionesEquipo = arrayListOf(
        "Real Madrid",
        "FC Barcelona",
        "Atlético de Madrid",
        "Sevilla FC",
        "Real Sociedad",
        "Villarreal CF",
        "Real Betis",
        "Athletic Club",
        "Valencia CF",
        "Granada CF",
        "Celta de Vigo",
        "Levante UD",
        "SD Eibar",
        "Getafe CF",
        "Deportivo Alavés",
        "SD Huesca",
        "Real Valladolid",
        "Elche CF",
        "CA Osasuna",
        "Cádiz CF"
    )

    fun Datos(
        nombre: String,
        equipo: String,
        posicones: String,
        goles: Int,
        equipoContra: String,
        fecha: String
    ) {
        var dato = DatosJugador(nombre, equipo, posicones, goles, equipoContra, fecha)
        ArrayBox.add(dato)
        println("  " + ArrayBox.size + "inside")
    }
}