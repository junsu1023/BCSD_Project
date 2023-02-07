package com.example.domain.usecase.user

import com.example.domain.repository.UserDataRepository
import javax.inject.Inject

class DeleteUser@Inject constructor(
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(uid: String) = userDataRepository.deleteUser(uid)
}