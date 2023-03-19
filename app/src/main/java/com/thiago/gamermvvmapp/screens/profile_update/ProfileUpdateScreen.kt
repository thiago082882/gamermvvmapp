package com.thiago.gamermvvmapp.screens.profile_update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thiago.gamermvvmapp.presentation.components.DefaultTopBar
import com.thiago.gamermvvmapp.screens.profile_update.component.ProfileUpdate
import com.thiago.gamermvvmapp.screens.profile_update.component.ProfileUpdateContent
import com.thiago.gamermvvmapp.screens.profile_update.component.SaveImage



@Composable
fun ProfileUpdateScreen(
    navController: NavHostController,
    user: String
) {
    Log.d("ProfileEditScreen", "Usuario: $user")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            ProfileUpdateContent(navController = navController)
        },
        bottomBar = {}
    )
    SaveImage()
    ProfileUpdate()
}