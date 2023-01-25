package com.example.dogbreedchallenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.dogbreedchallenge.data.entities.RandomDogEntity
import com.example.dogbreedchallenge.databinding.FragmentRandomDogDetailsBinding
import com.example.dogbreedchallenge.helpers.ImageLoadHelper.loadImageFromURL
import com.example.dogbreedchallenge.helpers.MessageErrorHelper
import com.example.dogbreedchallenge.ui.viewmodels.RandomDogDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RandomDogDetailsFragment: Fragment() {
    private lateinit var binding: FragmentRandomDogDetailsBinding
    private val model: RandomDogDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRandomDogDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLogic()
        setButtons()
    }

    private fun setLogic() {
        lifecycleScope.launch {
            model.loadNewDogImage()
            model.randomDogEntity.collect { randomDogEntity ->
                if (randomDogEntity.status == RandomDogEntity.SUCCESSFUL_CALL) {
                    binding.randomDogImage.loadImageFromURL(randomDogEntity.imageUrl)
                } else {
                    MessageErrorHelper.showMessageError(requireContext(), "")
                }
                binding.progressBar.hide()
            }
        }
    }

    private fun setButtons() {
        binding.randomDogButton.setOnClickListener {
            binding.progressBar.show()
            model.loadNewDogImage()
        }
    }

    private fun ProgressBar.show() {
        this.visibility = View.VISIBLE
    }

    private fun ProgressBar.hide() {
        this.visibility = View.GONE
    }
}