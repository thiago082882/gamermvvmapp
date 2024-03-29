package com.thiago.gamermvvmapp.domain.use_cases.users

import com.thiago.gamermvvmapp.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UsersRepository) {

    operator  fun invoke(id:String)= repository.getUserById(id)
}