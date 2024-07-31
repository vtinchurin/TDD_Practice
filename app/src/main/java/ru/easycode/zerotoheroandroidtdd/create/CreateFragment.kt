package ru.easycode.zerotoheroandroidtdd.create

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.CreateFrameBinding

class CreateFragment:AbstractFragment<CreateFrameBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CreateFrameBinding.inflate(inflater, container, false)
        return binding.root
    }

       override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = (activity as ProvideViewModel).viewModel(CreateViewModel::class.java)


        binding.createButton.setOnClickListener {
            viewModel.add(binding.inputEditText.text.toString())
        }

    }



}