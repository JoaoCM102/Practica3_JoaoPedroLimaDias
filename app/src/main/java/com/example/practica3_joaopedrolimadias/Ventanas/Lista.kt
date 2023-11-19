package com.example.practica3_joaopedrolimadias.Ventanas

import android.annotation.SuppressLint
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

