package com.esiea.androide4a.presentation.main.API

import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.http.GET

interface Launchlibrary {
    @GET("upcomminglaunch.json")
   fun getLaunchResponse(): Call<RestLaunchResponse>
}