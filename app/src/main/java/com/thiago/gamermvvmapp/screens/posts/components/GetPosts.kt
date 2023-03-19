package com.thiago.gamermvvmapp.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.gamermvvmapp.domain.model.Response
import com.thiago.gamermvvmapp.presentation.components.ProgressBar
import com.thiago.gamermvvmapp.screens.posts.PostsViewModel


@Composable
fun GetPosts(navController: NavHostController, viewModel: PostsViewModel = hiltViewModel()) {

    when (val response = viewModel.postsResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {

            PostsContent(
                navController = navController,
                posts = response.data
            )
        }
        is Response.Failure -> {

            Toast.makeText(LocalContext.current,
                response.exception?.message ?: "Error desconhecido",
                Toast.LENGTH_LONG).show()
        }

    }
}