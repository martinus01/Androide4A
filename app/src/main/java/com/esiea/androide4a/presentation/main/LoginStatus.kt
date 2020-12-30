package com.esiea.androide4a.presentation.main

sealed class LoginStatus

data class LoginSucess(val email : String,val password:String):LoginStatus()
object LoginERROR:LoginStatus()
