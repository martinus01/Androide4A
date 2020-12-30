package com.esiea.androide4a.domain.usecase

import com.esiea.androide4a.data.repository.UserRepository
import com.esiea.androide4a.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class GetUserUseCaseTest{
    private val userRepository:UserRepository= mockk()
    private val classUnderTest=GetUserUseCase(userRepository)


    @Test
    fun `invoke with invalid email`(){
        runBlocking {
            //GIVEN
            val email=""
            coEvery { userRepository.getUser((email)) }returns null
            //WHEN
            val result=classUnderTest.invoke(email)

            //THEN
            coVerify( exactly = 1) {userRepository.getUser(email) }
            assertEquals(result,null)
        }
    }


    @Test
    fun `invoke with valid email`(){
        runBlocking {
            //GIVEN
            val email = "a@a.c"
            val expectedUSer= User("a@a.c")
            coEvery { userRepository.getUser((email)) }returns expectedUSer
            //WHEN
            val result=classUnderTest.invoke(email)

            //THEN
            coVerify( exactly = 1) {userRepository.getUser(email) }
            assertEquals(result,expectedUSer)
        }
    }

}