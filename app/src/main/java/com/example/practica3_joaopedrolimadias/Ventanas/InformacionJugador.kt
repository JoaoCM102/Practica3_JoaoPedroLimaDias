package com.example.practica3_joaopedrolimadias.Ventanas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import com.example.practica3_joaopedrolimadias.Datos.ArrayBox
import com.example.practica3_joaopedrolimadias.Datos.DatosImagenInfoJugador
import com.example.practica3_joaopedrolimadias.Datos.DatosImagenInfoJugadorTexto
import com.example.practica3_joaopedrolimadias.R

@Composable
fun informacionJugador(){
    var jugador = ArrayBox[num]
    Column {
        Text(text = "${jugador.nombre}  que juega en ${jugador.equipo}")
        Image(painterResource(id = DatosImagenInfoJugador(jugador.nombre)), contentDescription = null)
        Text(stringResource(id = DatosImagenInfoJugadorTexto(jugador.nombre)))
        Text(text = "Nombre ${jugador.nombre} \nequipo ${jugador.equipo}\nposiciones ${jugador.posiciones}\nGoles ${jugador.goles}\nContra ${jugador.equipoContra}\nDia ${jugador.fecha}")
    }
    
    
}