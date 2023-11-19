package com.example.practica3_joaopedrolimadias.Ventanas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MenuPrincipal {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("NotConstructor")
    @Composable
    fun MenuPrincipal(){
        var textoSearchBar by remember { mutableStateOf("Buscar equipo") }
        var activeSearchBar by remember { mutableStateOf(false) }
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Bienvenido a tu fantasy Futbol" ,
                modifier = Modifier.fillMaxWidth())

            SearchBar(query = textoSearchBar,
                onQueryChange = {textoSearchBar = it},
                onSearch = {activeSearchBar = false},
                active = activeSearchBar,
                onActiveChange = {activeSearchBar = it}) {

            }
            Row(modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween) {
                ExtendedFloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier) {
                    Text(text = "Añadir")
                }
                ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {
                    Text(text = "Borrar")
                }
            }
        }
    }
    @Preview
    @Composable
    fun verComoVa(){
        MenuPrincipal()
    }
}