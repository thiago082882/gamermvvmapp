package com.thiago.gamermvvmapp.domain.use_cases.users

class UsersUseCases(
    val create: Create,
    val getUserById: GetUserById,
    val update: Update,
    val saveImage: SaveImage
)