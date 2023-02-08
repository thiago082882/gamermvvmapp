package com.thiago.gamermvvmapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.thiago.gamermvvmapp.domain.model.Response

interface AuthRepository {

    val currenUser: FirebaseUser?
    fun login(email: String, password: String): Response<FirebaseUser>

}