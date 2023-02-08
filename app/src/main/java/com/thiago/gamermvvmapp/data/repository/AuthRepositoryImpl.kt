package com.thiago.gamermvvmapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.thiago.gamermvvmapp.domain.model.Response
import com.thiago.gamermvvmapp.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth): AuthRepository {

    override val currentUser: FirebaseUser? get() = firebaseAuth.currentUser

    override suspend fun login(email: String, senha: String): Response<FirebaseUser> {
       return try {
             val result = firebaseAuth.signInWithEmailAndPassword(email, senha).await()
           Response.Success(result.user!!)
       }
       catch (e: Exception) {
           e.printStackTrace()
           Response.Failure(e)
       }
    }
}