package com.example.dogbreedchallenge.data.repositories

import javax.inject.Inject

class GetRandomDogUseCase @Inject constructor(
    private val randomDogRepository: RandomDogRepository
) {
    suspend operator fun invoke() = randomDogRepository.getRandomDog()
}