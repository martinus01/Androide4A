package com.esiea.androide4a.injection

import com.esiea.androide4a.presentation.main.MainViewModel
import org.koin.dsl.module

val presentationModule=module{
    factory { MainViewModel() }
}