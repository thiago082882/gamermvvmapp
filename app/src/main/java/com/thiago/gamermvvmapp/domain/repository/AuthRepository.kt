package com.thiago.gamermvvmapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.thiago.gamermvvmapp.domain.model.Response

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, senha: String): Response<FirebaseUser>

}