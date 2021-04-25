package com.caren.apps.doggo

import retrofit2.Call
import retrofit2.http.GET

interface DogEndpointInterface {

    @GET("image/random")
    suspend fun getRandomDogImage(): RandomDogImageResponse

}