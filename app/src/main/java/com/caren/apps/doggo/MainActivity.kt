package com.caren.apps.doggo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitInstance = RetrofitService().get()

        val apiService: DogEndpointInterface =
            retrofitInstance.create(DogEndpointInterface::class.java)

        apiService.getRandomDogImage().enqueue(object : Callback<RandomDogImageResponse> {
            override fun onResponse(
                call: Call<RandomDogImageResponse>,
                response: Response<RandomDogImageResponse>
            ) {
                if (response.body()?.status == "success") {
                    Log.i("Latte", "Successfully retrieved random doggo image!")
                    response.body()?.imageUrl?.also { imageUrl ->
                        Log.i("Latte", imageUrl)
                    }
                    // TODO Display image with imageURL
                } else {
                    Log.e("Latte", "Error retrieving doggo image")
                    Log.e("Latte", "Error: " + response.body()?.status)
                }
            }

            override fun onFailure(call: Call<RandomDogImageResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }
}