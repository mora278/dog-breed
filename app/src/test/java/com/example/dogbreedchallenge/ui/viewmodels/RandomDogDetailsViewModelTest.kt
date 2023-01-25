package com.example.dogbreedchallenge.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.dogbreedchallenge.data.entities.RandomDogEntity
import com.example.dogbreedchallenge.data.repositories.GetRandomDogUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class RandomDogDetailsViewModelTest {
    @RelaxedMockK
    private lateinit var getRandomDogUseCase: GetRandomDogUseCase

    private lateinit var model: RandomDogDetailsViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        model = RandomDogDetailsViewModel(getRandomDogUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel starts value is empty`() = runTest {
        val dogRandomEntity = RandomDogEntity.emptyEntity()

        assert(model.randomDogEntity.value.status == dogRandomEntity.status)
    }

    @Test
    fun `when viewmodel calls api successfully verify status`() = runTest {
        val dogRandomEntity = RandomDogEntity(RandomDogEntity.SUCCESSFUL_CALL, "")
        coEvery { getRandomDogUseCase() } returns dogRandomEntity

        model.loadNewDogImage()

        assert(model.randomDogEntity.value.status == dogRandomEntity.status)
    }
}