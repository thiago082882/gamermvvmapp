package com.thiago.gamermvvmapp.domain.use_cases.posts


import com.thiago.gamermvvmapp.domain.model.Post
import com.thiago.gamermvvmapp.domain.repository.PostRepository
import java.io.File
import javax.inject.Inject

class UpdatePost @Inject constructor(private val repository: PostRepository){

    suspend operator fun invoke(post: Post, file: File?) = repository.update(post, file)

}