package com.thiago.gamermvvmapp.domain.use_cases.posts

import com.thiago.gamermvvmapp.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsByIdUser @Inject constructor(private val repository: PostRepository) {

operator fun invoke(idUser : String) = repository.getPostsByUserId(idUser)
}