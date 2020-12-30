package com.esiea.androide4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.esiea.androide4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.loginliveData.observe(this, Observer {
            when(it){
                is LoginSucess ->{
                    //TODO navigate
                }
                LoginERROR -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("erreur")
                        .setMessage("compte inconnu")
                        .setPositiveButton("OK"){ dialog,which->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(),password_edit.text.toString())
        }


    }
}