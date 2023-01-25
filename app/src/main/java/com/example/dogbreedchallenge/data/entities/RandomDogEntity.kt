package com.example.dogbreedchallenge.data.entities

import com.google.gson.annotations.SerializedName

data class RandomDogEntity(
    @SerializedName("status") var status: String,
    @SerializedName("message") var imageUrl: String
) {
    companion object {
        const val SUCCESSFUL_CALL = "success"
        const val UNSUCCESSFUL_CALL = "failure"
        fun emptyEntity(): RandomDogEntity = RandomDogEntity(
            status = UNSUCCESSFUL_CALL,
            imageUrl = ""
        )
    }
}