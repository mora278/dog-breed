package com.example.dogbreedchallenge.data.network

import com.example.dogbreedchallenge.data.entities.RandomDogEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getRandomDog(@Url url: String): Response<RandomDogEntity>
}