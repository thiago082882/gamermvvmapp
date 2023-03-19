package com.thiago.gamermvvmapp.screens.update_post

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.gamermvvmapp.presentation.components.DefaultButton
import com.thiago.gamermvvmapp.presentation.components.DefaultTopBar
import com.thiago.gamermvvmapp.screens.update_post.components.UpdatePost
import com.thiago.gamermvvmapp.screens.update_post.components.UpdatePostContent

@Composable
fun UpdatePostScreen(navController: NavHostController, post: String, viewModel: UpdatePostViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
             DefaultTopBar(
                 title = "Editar Post",
                 upAvailable = true,
                 navController = navController
             )
        },
        content = {
            UpdatePostContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "ATUALIZAR",
                onClick = { viewModel.onUpdatePost() }
            )
        }
    )
    UpdatePost()

}