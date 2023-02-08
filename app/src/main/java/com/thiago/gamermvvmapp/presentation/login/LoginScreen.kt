package com.thiago.gamermvvmapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.thiago.gamermvvmapp.presentation.login.component.LoginBottomBar
import com.thiago.gamermvvmapp.presentation.login.component.LoginContent
import com.thiago.gamermvvmapp.presentation.ui.theme.GamerMVVMAPPTheme


@Composable
fun LoginScreen(navController: NavHostController) {



    Scaffold(
        topBar = {},
        content = {
            LoginContent()
        },
        bottomBar = {

            LoginBottomBar(navController)
        }

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GamerMVVMAPPTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LoginScreen(rememberNavController())
        }
    }
}