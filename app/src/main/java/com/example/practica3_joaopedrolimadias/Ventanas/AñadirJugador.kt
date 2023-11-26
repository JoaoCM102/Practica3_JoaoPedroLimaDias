package com.example.practica3_joaopedrolimadias.Ventanas

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.practica3_joaopedrolimadias.Datos.DatosArray
import com.example.practica3_joaopedrolimadias.Datos.convertirMillisAFecha
import com.example.practica3_joaopedrolimadias.Datos.lista
import com.example.practica3_joaopedrolimadias.Datos.radioBoton
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.minutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AñadirJugador(navController: NavController){
    var texto by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var recogerTextoJugador by remember { mutableStateOf("") }
    var recogerTextoEquipo by remember { mutableStateOf("") }
    var recogerTextoPosicion by remember { mutableStateOf("") }
    var recogerTextoEquipoContra by remember { mutableStateOf("") }
    var recogerGoles by remember { mutableStateOf("") }
    var movimientoSlider by remember { mutableFloatStateOf(0f) }
    var DisminuirPiker by remember { mutableStateOf(false) }
    val opcionesEquipo = DatosArray().opcionesEquipo
    val opcionesJugador = DatosArray().opcionesJugador
    var expandir by remember { mutableStateOf(false) }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(text = "Introduce el nombre del jugador:")
        lista(lista = opcionesJugador, recogerTexto = {nuevoValor -> recogerTextoJugador = nuevoValor})
        Text(text = "Introduce el equipo en el que juega:")
        lista(lista = opcionesEquipo, recogerTexto = {nuevoValor -> recogerTextoEquipo = nuevoValor})
        Text(text = "Selecciona una o mas posiciones")
        radioBoton(Posicion = "DEL", { nuevoValor -> recogerTextoPosicion = nuevoValor } , textoTotalPos = recogerTextoPosicion)
        radioBoton(Posicion = "MED", { nuevoValor -> recogerTextoPosicion = nuevoValor } , textoTotalPos = recogerTextoPosicion)
        radioBoton(Posicion = "DEF", { nuevoValor -> recogerTextoPosicion = nuevoValor } , textoTotalPos = recogerTextoPosicion)
        radioBoton(Posicion = "POR", { nuevoValor -> recogerTextoPosicion = nuevoValor } , textoTotalPos = recogerTextoPosicion)
        recogerTextoPosicion = recogerTextoPosicion.trim()
        Text(text = "El numero de goles que metio en el partido")
        Slider(value = movimientoSlider,
            onValueChange = {movimientoSlider = it},
            valueRange = 0f..5f, steps = 4)
        Text("${movimientoSlider.toInt()}")
        Text(text = "El equipo contra el que jugo:")
        lista(lista = opcionesEquipo, recogerTexto = {nuevoValor -> recogerTextoEquipoContra = nuevoValor})
        val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
        DatePicker(state = state,
            modifier = Modifier,
            title = {
                Row {
                    Text(text = "Seleccionar la fecha del partido")
                }
            })
        BackHandler {

            fecha = state.selectedDateMillis?.let { convertirMillisAFecha(it) }.toString()

            DatosArray().Datos(recogerTextoJugador,recogerTextoEquipo,recogerTextoPosicion,movimientoSlider.toInt(),recogerTextoEquipoContra,fecha)
            navController.popBackStack()
        }
        

    }


    }
