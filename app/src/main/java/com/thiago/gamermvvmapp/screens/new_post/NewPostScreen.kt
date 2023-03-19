package com.thiago.gamermvvmapp.screens.new_post

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.gamermvvmapp.presentation.components.DefaultButton
import com.thiago.gamermvvmapp.presentation.components.DefaultTopBar
import com.thiago.gamermvvmapp.screens.new_post.components.NewPost
import com.thiago.gamermvvmapp.screens.new_post.components.NewPostContent


@Composable
fun NewPostScreen(navController: NavHostController, viewModel: NewPostViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Novo Post",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            NewPostContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "PUBLICAR",
                onClick = { viewModel.onNewPost() }
            )
        }
    )
    NewPost()

}