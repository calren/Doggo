package com.caren.apps.doggo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitService {

    private val BASE_URL = "https://dog.ceo/api/breeds/"

    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun get(): Retrofit {
        return retrofitInstance
    }
}