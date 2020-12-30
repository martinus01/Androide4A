package com.esiea.androide4a.presentation.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.esiea.androide4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.login_edit
import kotlinx.android.synthetic.main.activity_main.password_edit
import kotlinx.android.synthetic.main.register_layout.*
import org.koin.android.ext.android.inject

class RegisterUser : AppCompatActivity(){
    val mainViewModel:MainViewModel by inject()
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)
/*
        create_button.setOnClickListener {
            mainViewModel.onClickedCreate(login_input_layout_account.text.toString().trim(),password_input_layout_account.test.toString())
        }

        mainViewModel.createLiveData.observe(this,androidx.lifecycle.Observer{
            when(it) {
                is CreateSucess->{
                    mainViewModel.onClickedCreate(login_input_layout_account.text.toString().trim(),password_input_layout_account.test.toString())
                }
                is CreateERROR->{
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erro")
                        .setMessage("un erreur est survenu lor de la creation")
                        .setPositiveButton("OK"){dialog,which->dialog.dismiss()}.show()
                }
            }
        })*/

    }



}
