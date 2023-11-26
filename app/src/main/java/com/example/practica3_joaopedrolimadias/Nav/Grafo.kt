package com.example.practica3_joaopedrolimadias.Nav

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica3_joaopedrolimadias.Rutas
import com.example.practica3_joaopedrolimadias.Ventanas.AñadirJugador
import com.example.practica3_joaopedrolimadias.Ventanas.MenuPrincipal
import com.example.practica3_joaopedrolimadias.Ventanas.informacionJugador

@Composable
fun GrafoNavegacion(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.MenuPrincipal.ruta) {

        // "URL" -> Composable
        composable(Rutas.MenuPrincipal.ruta){
            MenuPrincipal().MenuPrincipal(navController = navController)
        }

        composable(Rutas.AñadirJugador.ruta){
            AñadirJugador(navController = navController)
        }

        composable(Rutas.InformacionJugador.ruta){
            informacionJugador()
        }

    }
}


