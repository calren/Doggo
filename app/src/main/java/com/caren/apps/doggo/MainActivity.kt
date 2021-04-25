package com.caren.apps.doggo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitInstance = RetrofitService().get()

        val apiService: DogEndpointInterface =
            retrofitInstance.create(DogEndpointInterface::class.java)

        lifecycleScope.launch {
            val response = apiService.getRandomDogImage()

            val responseStatus = response.status
            Log.i("Latte", "response status: ${responseStatus}")
            if (responseStatus.equals("success")) {
                Log.i("Latte", "image: ${response.imageUrl}")
            }
        }
    }
}