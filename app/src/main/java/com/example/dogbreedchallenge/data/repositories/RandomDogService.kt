package com.example.dogbreedchallenge.data.repositories

import com.example.dogbreedchallenge.data.entities.RandomDogEntity
import com.example.dogbreedchallenge.data.network.APIService
import javax.inject.Inject

class RandomDogService @Inject constructor(
    private val apiService: APIService
) {
    suspend fun getRandomDog(): RandomDogEntity = apiService.getRandomDog("image/random").body() ?: RandomDogEntity.emptyEntity()
}