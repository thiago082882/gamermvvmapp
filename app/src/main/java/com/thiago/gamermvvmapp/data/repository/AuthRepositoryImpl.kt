package com.thiago.gamermvvmapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.thiago.gamermvvmapp.domain.model.Response
import com.thiago.gamermvvmapp.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    val firebaseAuth = FirebaseAuth.getInstance()

    override val currenUser: FirebaseUser?get() = firebaseAuth.currentUser

    override fun login(email: String, password: String): Response<FirebaseUser> {
        TODO("Not yet implemented")
    }
}