package com.thiago.gamermvvmapp.domain.use_cases.posts


import com.thiago.gamermvvmapp.domain.repository.PostRepository
import javax.inject.Inject

class DeleteLikePost @Inject constructor(private val repository: PostRepository){

    suspend operator fun invoke(idPost: String, idUser: String) = repository.deleteLike(idPost, idUser)

}