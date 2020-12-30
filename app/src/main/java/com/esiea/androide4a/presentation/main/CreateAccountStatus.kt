package com.esiea.androide4a.presentation.main

sealed class CreateAccountStatus

data class CreateSucess(val email:String,val password:String):CreateAccountStatus()

object CreateERROR:CreateAccountStatus()