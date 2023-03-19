package com.thiago.gamermvvmapp.domain.use_cases.posts

import com.thiago.gamermvvmapp.domain.repository.PostRepository
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: PostRepository) {

operator fun invoke() = repository.getPosts()
}