package com.example.practica3_joaopedrolimadias.MenuPrincipal

import android.annotation.SuppressLint
import android.app.appsearch.AppSearchBatchResult
import android.app.appsearch.SearchResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

class MenuPrincipal {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("NotConstructor")
    @Composable
    fun MenuPrincipal(){
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Bienvenido a tu fantasy Futbol" ,
                modifier = Modifier.fillMaxWidth())

            SearchBar(query = "Dato",
                onQueryChange = {"Dato"},
                onSearch = {},
                active = true,
                onActiveChange = {}) {

            }
            Row {
                ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {}
                ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {}
            }
        }
    }
    @Preview
    @Composable
    fun verComoVa(){
        MenuPrincipal()
    }
}