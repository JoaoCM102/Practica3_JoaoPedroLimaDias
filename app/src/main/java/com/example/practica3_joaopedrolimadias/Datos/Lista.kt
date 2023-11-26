package com.example.practica3_joaopedrolimadias.Datos

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.widget.Switch
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.practica3_joaopedrolimadias.R
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun lista( lista : ArrayList<String>,recogerTexto : (String)-> Unit){
    var texto by remember { mutableStateOf("") }
    val opciones = lista
    var expandir by remember { mutableStateOf(false) }

        ExposedDropdownMenuBox(expanded = expandir, onExpandedChange = {expandir = !expandir} , modifier = Modifier.fillMaxWidth()) {
            TextField(value = texto,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                label = { Text("Seleccionar opcion") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandir) }
            )
            DropdownMenu(expanded = expandir , onDismissRequest = { expandir = false }) {
                opciones.forEach { elemento ->
                    DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                        text = { Text(elemento) },
                        onClick = { texto = elemento;recogerTexto(
                            elemento
                        )}

                    )
                }

            }
        }


}

@SuppressLint("ComposableNaming")
@Composable
fun radioBoton(Posicion : String,valorPosicion : (String) -> Unit , textoTotalPos : String){
    var Pulsado by remember { mutableStateOf(false) }
    
    Row(modifier = Modifier.fillMaxWidth()) {
        RadioButton(selected = Pulsado, onClick = { Pulsado = !Pulsado;
            if (Pulsado){
                if (textoTotalPos.contains("$Posicion")){
                    valorPosicion("$textoTotalPos")
                }else{valorPosicion("$textoTotalPos $Posicion")}
                }
        else{
            if (textoTotalPos.contains("$Posicion")){
                val textoTotalPos = textoTotalPos.replace("$Posicion","")
                valorPosicion("$textoTotalPos")
            }
        }})
        Text(text = Posicion)
    }
}

fun DatosImagen(nombre : String):Int {
    val Valor = when{
        nombre == "Messi" -> R.drawable.messi
        nombre == "Cristiano" -> R.drawable.cristiano
        nombre == "Griezman" -> R.drawable.griezman
        nombre == "Mbappe" -> R.drawable.mbappe
        nombre == "Halaand" -> R.drawable.halaand
        nombre == "Modric" -> R.drawable.modric
        nombre == "Pedri" -> R.drawable.pedri
        nombre == "Gavi" -> R.drawable.gabbi
        nombre == "Musiala" -> R.drawable.musiala
        nombre == "Saka" -> R.drawable.saka
        else -> 0
    }
    return Valor
}
fun DatosImagenInfoJugador(nombre : String):Int {
    val Valor = when{
        nombre == "Messi" -> R.drawable.messiinformacion
        nombre == "Cristiano" -> R.drawable.cristianoinformacion
        nombre == "Griezman" -> R.drawable.griezmaninfo
        nombre == "Mbappe" -> R.drawable.mbappeinfo
        nombre == "Halaand" -> R.drawable.halaandinfo
        nombre == "Modric" -> R.drawable.modricinfo
        nombre == "Pedri" -> R.drawable.pedriinfo
        nombre == "Gavi" -> R.drawable.gaviinfo
        nombre == "Musiala" -> R.drawable.musialainfo
        nombre == "Saka" -> R.drawable.sakainfo
        else -> 0
    }
    return Valor
}
fun DatosImagenInfoJugadorTexto(nombre : String):Int {
    val Valor = when{
        nombre == "Messi" -> R.string.messi
        nombre == "Cristiano" -> R.string.cristiano
        nombre == "Griezman" -> R.string.griezman
        nombre == "Mbappe" -> R.string.mbappe
        nombre == "Halaand" -> R.string.halaand
        nombre == "Modric" -> R.string.modric
        nombre == "Pedri" -> R.string.pedri
        nombre == "Gavi" -> R.string.gavi
        nombre == "Musiala" -> R.string.musiala
        nombre == "Saka" -> R.string.saka
        else -> 0
    }
    return Valor
}
fun obtenerColorEquipo(nombreEquipo: String): Color {
    return when (nombreEquipo) {
        "Real Madrid" -> Color.White // Azul oscuro
        "FC Barcelona" -> Color(0xFFA50044) // Granate
        "Atlético de Madrid" -> Color(0xFFCB3524) // Rojo
        "Sevilla FC" -> Color(0xFFFFD100) // Amarillo
        "Real Sociedad" -> Color(0xFF0033A0) // Azul
        "Villarreal CF" -> Color(0xFFFFD100) // Amarillo
        "Real Betis" -> Color(0xFF12A749) // Verde
        "Athletic Club" -> Color(0xFFEE1D23) // Rojo
        "Valencia CF" -> Color(0xFFFF7F00) // Naranja
        "Granada CF" -> Color(0xFF336699) // Azul
        "Celta de Vigo" -> Color(0xFF90C5D8) // Celeste
        "Levante UD" -> Color(0xFFEB1C26) // Rojo
        "SD Eibar" -> Color(0xFF005CA5) // Azul
        "Getafe CF" -> Color(0xFF2E3092) // Azul oscuro
        "Deportivo Alavés" -> Color(0xFFD0103A) // Rojo oscuro
        "SD Huesca" -> Color(0xFF005BBF) // Azul
        "Real Valladolid" -> Color(0xFF910048) // Púrpura oscuro
        "Elche CF" -> Color(0xFF006DAE) // Azul
        "CA Osasuna" -> Color(0xFFD21034) // Rojo oscuro
        "Cádiz CF" -> Color(0xFFD51F28) // Rojo oscuro
        else -> Color.Gray // Color por defecto si el equipo no tiene asignado un color
    }
}
fun convertirMillisAFecha(millis: Long): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    val fecha = Date(millis)
    return sdf.format(fecha)
}