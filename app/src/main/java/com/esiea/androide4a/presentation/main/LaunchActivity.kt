package com.esiea.androide4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.esiea.androide4a.R
import com.esiea.androide4a.presentation.main.API.Launchlibrary
import com.esiea.androide4a.presentation.main.API.Listadapter
import com.esiea.androide4a.presentation.main.API.RestLaunchResponse
import kotlinx.android.synthetic.main.activity_launch.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val BASE_URL: String ="https://raw.githubusercontent.com/martinus01/SpaceLaunch_appli/develop/"
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Launchlibrary::class.java)

        api.getLaunchResponse().enqueue(object : Callback<RestLaunchResponse> {
            override fun onResponse(
                call: Call<RestLaunchResponse>,
                response: Response<RestLaunchResponse>
            ) {
                if(response.body()!=null){
                ShowData(response.body()!!)
                }
                /*recycler_view.apply {
                    layoutManager = LinearLayoutManager(this@LaunchActivity)
                    adapter = Listadapter(response.body()!!.launches, this@LaunchActivity)*/
                }

                override fun onFailure(call: Call<RestLaunchResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

        })

        }
    private fun ShowData(body: RestLaunchResponse) {
        recycler_view.apply{
            layoutManager=LinearLayoutManager(this@LaunchActivity)
            adapter= Listadapter(body.launches,this@LaunchActivity)
        }
    }
}
