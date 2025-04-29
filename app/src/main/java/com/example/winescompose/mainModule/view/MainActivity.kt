package com.example.winescompose.mainModule.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.winescompose.homeModule.view.WineList
import com.example.winescompose.ui.theme.WinesComposeTheme
import kotlinx.coroutines.launch

/****
 * Project: Wines Compose
 * From: com.cursosant.winescompose.mainModule.view
 * Created by Alain Nicolás Tello on 06/03/24 at 15:56
 * All rights reserved 2024.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 ***/
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WinesComposeTheme {
                val snackbarHostState = remember { SnackbarHostState()}
                val coroutineScope = rememberCoroutineScope()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    content = {
                   WineList(onSnackbarMsg = { resMsg ->
                       coroutineScope.launch { snackbarHostState.showSnackbar(message = resMsg) }
                   })
                }, snackbarHost = { SnackbarHost( hostState = snackbarHostState) } )
            }
        }
    }
}