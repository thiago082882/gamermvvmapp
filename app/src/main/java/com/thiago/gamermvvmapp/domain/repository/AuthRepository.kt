package com.thiago.gamermvvmapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.thiago.gamermvvmapp.domain.model.Response
import com.thiago.gamermvvmapp.domain.model.User

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, senha: String): Response<FirebaseUser>
    suspend fun signUp(user: User): Response<FirebaseUser>
    fun logout()
}