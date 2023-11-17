package com.example.practica3_joaopedrolimadias

sealed class Rutas(val ruta: String) {
    /* TODO
        Crear e identificar las rutas (diferentes pantallas) de nuestra app
     */
    object PantallaUno: Rutas("MenuPrincipal")
    object PantallaDos: Rutas("AñadirJugador")
    object PantallaTres: Rutas("VentanaTres")
    object PantallaCuatro: Rutas("VentanaCuatro")
    object PantallaCinco: Rutas("VentanaCinco")
}
