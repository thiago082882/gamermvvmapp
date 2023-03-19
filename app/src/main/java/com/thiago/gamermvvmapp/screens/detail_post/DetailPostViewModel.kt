package com.thiago.gamermvvmapp.screens.detail_post

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.thiago.gamermvvmapp.domain.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailPostViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle

): ViewModel() {

    val data = savedStateHandle.get<String>("post")
    val post = Post.fromJson(data!!)
}