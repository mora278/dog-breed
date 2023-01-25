package com.example.dogbreedchallenge.data.repositories

import com.example.dogbreedchallenge.data.entities.RandomDogEntity
import javax.inject.Inject

class RandomDogRepository @Inject constructor(
    private val randomDogService: RandomDogService
) {
    // Use network or database
    suspend fun getRandomDog(): RandomDogEntity = randomDogService.getRandomDog()
}