package com.thiago.gamermvvmapp.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.gamermvvmapp.domain.model.Response
import com.thiago.gamermvvmapp.presentation.components.ProgressBar
import com.thiago.gamermvvmapp.screens.posts.PostsViewModel

@Composable
fun DeleteLikePost(viewModel: PostsViewModel = hiltViewModel()) {

    when(val response = viewModel.deleteLikeResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {

        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconhecido", Toast.LENGTH_LONG).show()
        }

    }

}