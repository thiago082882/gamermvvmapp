package com.thiago.gamermvvmapp.domain.use_cases.auth

import com.thiago.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser  @Inject constructor(private val repository : AuthRepository ){

operator  fun invoke() = repository.currentUser

}