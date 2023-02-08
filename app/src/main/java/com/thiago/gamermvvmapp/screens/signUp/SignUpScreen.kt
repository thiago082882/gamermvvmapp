package com.thiago.gamermvvmapp.screens.signUp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thiago.gamermvvmapp.components.DefaultTopBar
import com.thiago.gamermvvmapp.presentation.ui.theme.GamerMVVMAPPTheme
import com.thiago.gamermvvmapp.screens.signUp.components.SignUpContent

@Composable
fun SignUpScreen(navController: NavHostController) {
    Scaffold(

        topBar = {

            DefaultTopBar(
                title = "Novo Usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
           SignUpContent()
        },
        bottomBar = { }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignUpScreen() {
    GamerMVVMAPPTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SignUpScreen(rememberNavController())
        }
    }

}