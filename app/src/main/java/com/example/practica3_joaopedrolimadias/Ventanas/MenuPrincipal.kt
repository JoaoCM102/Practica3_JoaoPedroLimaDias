package com.example.practica3_joaopedrolimadias.Ventanas

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practica3_joaopedrolimadias.Datos.ArrayBox
import com.example.practica3_joaopedrolimadias.Datos.DatosArray
import com.example.practica3_joaopedrolimadias.Datos.DatosImagen
import com.example.practica3_joaopedrolimadias.Datos.DatosJugador
import com.example.practica3_joaopedrolimadias.Datos.obtenerColorEquipo
import com.example.practica3_joaopedrolimadias.R
import com.example.practica3_joaopedrolimadias.Rutas
var num : Int = 0;
class MenuPrincipal {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("NotConstructor")
    @Composable
    fun MenuPrincipal(navController: NavController) {
        var textoSearchBar by remember { mutableStateOf("") }
        var activeSearchBar by remember { mutableStateOf(false) }
        var listaMutable  = remember { mutableStateListOf<DatosJugador>(). apply { addAll(ArrayBox) } }
        var botonCheck by remember { mutableStateOf(false) }
        var borrar by remember { mutableStateOf(false) }
        var Borrar = ArrayList<Int>()
        var filtro by remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Bienvenido a tu fantasy Futbol",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                query = textoSearchBar,
                onQueryChange = { textoSearchBar = it },
                onSearch = { activeSearchBar = false },
                active = activeSearchBar,
                onActiveChange = { activeSearchBar = it }) {
                val filtrarEquipos =
                    DatosArray().opcionesEquipo.filter { it.contains(textoSearchBar, true) }
                for (i in filtrarEquipos.indices) {
                    Button(onClick = { filtro = "${filtrarEquipos[i]}" },
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(border = BorderStroke(1.dp, Color.Blue), shape = RectangleShape))
                            {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(65.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        painterResource(id = R.drawable.ic_star),
                                        contentDescription = null,
                                        Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)
                                    )
                                    Text(
                                        text = "${filtrarEquipos[i]}",
                                        Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
                                    )
                                }
                                Icon(
                                    painterResource(id = R.drawable.ic_group),
                                    contentDescription = null,
                                    Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp)
                                )
                            }
                        }
                    }

                }


            }
            LazyColumn() {
                items(listaMutable) { jugador ->
                    if (textoSearchBar == ""){
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(obtenerColorEquipo(jugador.equipo))
                        ) {
                            Column {


                                var CheckPulsado by remember { mutableStateOf(false) }
                                var habilitado by remember { mutableStateOf(true) }
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Image(
                                        painterResource(id = DatosImagen(jugador.nombre)),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(90.dp)
                                    )
                                    Column(modifier = Modifier.weight(3f)) {
                                        Text(
                                            text = "${jugador.nombre}",
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = " Vs ${jugador.equipoContra} , ${jugador.fecha}",
                                                textAlign = TextAlign.Center
                                            )
                                            if (botonCheck == true) {
                                                Checkbox(
                                                    checked = CheckPulsado,
                                                    onCheckedChange = {
                                                        CheckPulsado = !CheckPulsado
                                                    },
                                                    enabled = habilitado,
                                                    modifier = Modifier
                                                )

                                                if (CheckPulsado == true) {
                                                    Borrar.add(listaMutable.indexOf(jugador))


                                                }
                                            }
                                        }

                                        Text(
                                            text = "${jugador.goles}",
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                    }
                                }
                                Button(onClick = { navController?.navigate(Rutas.InformacionJugador.ruta)
                                num = listaMutable.indexOf(jugador)}) {
                                    Text(text = "Informacion")
                                }
                            }
                        }
                    }else if ("${jugador.equipo}" == filtro){
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(obtenerColorEquipo(jugador.equipo))
                        ) {
                            var CheckPulsado by remember { mutableStateOf(false) }
                            var habilitado by remember { mutableStateOf(true) }
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Image(
                                    painterResource(id = DatosImagen(jugador.nombre)),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(90.dp)
                                )
                                Column(modifier = Modifier.weight(3f)) {
                                    Text(
                                        text = "${jugador.nombre}",
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = " Vs ${jugador.equipoContra} , ${jugador.fecha}",
                                            textAlign = TextAlign.Center
                                        )
                                        if (botonCheck == true) {
                                            Checkbox(
                                                checked = CheckPulsado,
                                                onCheckedChange = { CheckPulsado = !CheckPulsado },
                                                enabled = habilitado,
                                                modifier = Modifier
                                            )

                                            if (CheckPulsado == true) {
                                                Borrar.add(listaMutable.indexOf(jugador))


                                            }
                                        }
                                    }

                                    Text(
                                        text = "${jugador.goles}",
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }

                }
            }
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ExtendedFloatingActionButton(
                    onClick = { navController?.navigate(Rutas.AñadirJugador.ruta) },
                    modifier = Modifier
                ) {
                    Text(text = "Añadir")
                    Icon(
                        painterResource(id = R.drawable.ic_action_add),
                        contentDescription = null,
                        modifier = Modifier.size(27.dp)
                    )
                }
                ExtendedFloatingActionButton(onClick = {
                    if (borrar == false) {
                        botonCheck = !botonCheck
                        borrar = true
                    } else {
                        for (i in 0 until Borrar.size - 1) {
                            // i = 0,1,2
                            ArrayBox.removeAt(Borrar[i])
                            println(ArrayBox.size)
                            listaMutable.clear()
                            Borrar.clear()
                            listaMutable.addAll(ArrayBox)
                        }
                        botonCheck = !botonCheck
                    }
                    println(Borrar.size)
                    // borrar -> 2,4,1
                    // solo borrar cuando pase de verdadeor a falso

                }) {
                    Text(text = "Borrar")
                    Icon(painterResource(id = R.drawable.iconoborrar), contentDescription = null)
                }
            }



            }

        }


    }

    @Preview
    @Composable
    fun verComoVa() {
        MenuPrincipal()
    }


