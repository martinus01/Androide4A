package com.esiea.androide4a.presentation.main.API


data class RestLaunchResponse (
    val launches: MutableList<Launch>,
    val total: Int,
    val count: Int,
){}
