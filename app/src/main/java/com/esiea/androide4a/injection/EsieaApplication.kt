package com.esiea.androide4a.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EsieaApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        //start Koin!
        startKoin {
            //android context
            androidContext(this@EsieaApplication)
            //modules
            modules(presentationModule,domaineModule,dataModule)
        }
    }
}