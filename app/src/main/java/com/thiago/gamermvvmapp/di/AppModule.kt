package com.thiago.gamermvvmapp.di

import com.google.firebase.auth.FirebaseAuth
import com.thiago.gamermvvmapp.data.repository.AuthRepositoryImpl
import com.thiago.gamermvvmapp.domain.repository.AuthRepository
import com.thiago.gamermvvmapp.domain.use_cases.auth.AuthUseCases
import com.thiago.gamermvvmapp.domain.use_cases.auth.GetCurrentUser
import com.thiago.gamermvvmapp.domain.use_cases.auth.Login
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl : AuthRepositoryImpl): AuthRepository = impl


    @Provides
    fun provideAuthUseCases(repository: AuthRepository)= AuthUseCases(

        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
    )

}