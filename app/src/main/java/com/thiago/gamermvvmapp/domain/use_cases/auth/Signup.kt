package com.thiago.gamermvvmapp.domain.use_cases.auth

import com.thiago.gamermvvmapp.domain.model.User
import com.thiago.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.signUp(user)

}