package com.caren.apps.doggo

import com.google.gson.annotations.SerializedName

class RandomDogImageResponse {
    @SerializedName("message")
    var imageUrl: String? = null

    @SerializedName("status")
    var status: String? = null
}