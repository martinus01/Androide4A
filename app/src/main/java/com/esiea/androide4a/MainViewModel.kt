package com.esiea.androide4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){

    val text: MutableLiveData<String> = MutableLiveData()

    init {
        text.value="Texte livedata"


    }
}