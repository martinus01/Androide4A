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
     val createUserUseCase:CreateUserUseCase,
     val getUserUseCase:GetUserUseCase
) :ViewModel(){

    val loginliveData: MutableLiveData<LoginStatus> = MutableLiveData()
    val createLiveData: MutableLiveData<CreateAccountStatus> = MutableLiveData()

    fun onClickedLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user= getUserUseCase.invoke(email,password)
            var loginStatus:LoginStatus =
                if(email !=null&&password!=null){
                       LoginSucess(email,password)
            }else{
                LoginERROR
            }
            withContext(Dispatchers.Main){
            loginliveData.value = loginStatus}
        }
    }

    fun onClickedCreate(email: String,password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val createAccountStatus:CreateAccountStatus =
                if(email !=null&&password!=null){
                        createUserUseCase.invoke(user = User(email, password))
                        CreateSucess(email,password)
                }else{
                    CreateERROR
                }
            withContext(Dispatchers.Main){
                createLiveData.value = createAccountStatus}
        }
    }
    fun userExist(email: String,password: String)
    {
        viewModelScope.launch(Dispatchers.IO){

            var createAccountStatus:CreateAccountStatus
            if(email == "")
            {
                createAccountStatus=CreateERROR
            }
            val user:User?=getUserUseCase.invoke(email,password)
            createAccountStatus=if(user==null) {
                CreateSucess(email, password)
            }else{
                CreateERROR
            }
            withContext(Dispatchers.Main){
                createLiveData.value=createAccountStatus
            }
        }
    }

    }

