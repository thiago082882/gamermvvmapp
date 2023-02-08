package com.thiago.gamermvvmapp.domain.use_cases.auth

import com.thiago.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject


    class  Login @Inject constructor(private val repository: AuthRepository){

        suspend operator fun invoke(email: String, senha: String) = repository.login(email, senha)
    }
