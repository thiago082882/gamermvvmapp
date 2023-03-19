package com.thiago.gamermvvmapp.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.gamermvvmapp.screens.profile.components.ProfileContent


@Composable
fun ProfileScreen(navController: NavHostController,viewModel: ProfileViewModel= hiltViewModel()) {

    Scaffold (
        topBar = {},
        content = {
           ProfileContent(navController)
        },
        bottomBar = {}
            )

    }
