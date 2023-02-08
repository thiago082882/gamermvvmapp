package com.thiago.gamermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thiago.gamermvvmapp.presentation.login.LoginScreen
import com.thiago.gamermvvmapp.screens.signUp.SignUpScreen


@Composable
fun AppNavigation(navController : NavHostController){

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route

    ) {
          composable(
              route = AppScreen.Login.route){
              LoginScreen(navController)
          }

        composable(
            route = AppScreen.SignUp.route){

            SignUpScreen(navController)
        }
    }
}