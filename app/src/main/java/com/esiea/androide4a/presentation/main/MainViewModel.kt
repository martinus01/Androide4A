package com.esiea.androide4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.androide4a.domain.entity.User
import com.esiea.androide4a.domain.usecase.CreateUserUseCase
import com.esiea.androide4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase:CreateUserUseCase,
    private val getUserUseCase:GetUserUseCase
) :ViewModel(){

    val loginliveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser)
            val loginStatus= if(user !=null){
                LoginSucess(user.email)
            }else{
                LoginERROR
            }
            withContext(Dispatchers.Main){
            loginliveData.value = loginStatus}
        }
    }


    fun onClickedCreate(emailUser: String,password: String){
        viewModelScope.launch(Dispatchers.IO){
            createUserUseCase.invoke(user = User(emailUser,password))
        }
    }
}