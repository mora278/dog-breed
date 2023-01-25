package com.example.dogbreedchallenge.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedchallenge.data.entities.RandomDogEntity
import com.example.dogbreedchallenge.data.repositories.GetRandomDogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomDogDetailsViewModel @Inject constructor(
    private val getRandomDogUseCase: GetRandomDogUseCase
): ViewModel() {
    private val _randomDogEntity: MutableStateFlow<RandomDogEntity> = MutableStateFlow(RandomDogEntity.emptyEntity())
    val randomDogEntity: StateFlow<RandomDogEntity> = _randomDogEntity

    fun loadNewDogImage() = viewModelScope.launch {
        _randomDogEntity.value = getRandomDogUseCase()
    }
}