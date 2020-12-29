package com.esiea.androide4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    fun onClickedIncrement() {
    counter.value = (counter.value ?: 0) + 1
    }

    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value=0


    }
}