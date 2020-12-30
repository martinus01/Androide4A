package com.esiea.androide4a.domain.usecase

import com.esiea.androide4a.data.repository.UserRepository
import com.esiea.androide4a.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String,password:String) : User? {
        return userRepository.getUser(email,password)

    }
}