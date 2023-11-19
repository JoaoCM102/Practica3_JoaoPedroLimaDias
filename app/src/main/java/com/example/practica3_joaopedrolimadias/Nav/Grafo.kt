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
@Composable
fun GrafoNavegacion(context: Context){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.PantallaUno.ruta) {

        // "URL" -> Composable
        composable(Rutas.PantallaUno.ruta){
        }

        composable(Rutas.PantallaDos.ruta){
        }

        composable(Rutas.PantallaTres.ruta){
        }

        composable(Rutas.PantallaCuatro.ruta){
        }
        composable(Rutas.PantallaCinco.ruta){
        }
    }
}


