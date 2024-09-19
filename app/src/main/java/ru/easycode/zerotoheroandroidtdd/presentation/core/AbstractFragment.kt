package ru.easycode.zerotoheroandroidtdd.presentation.core

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import ru.easycode.zerotoheroandroidtdd.presentation.AddScreen

abstract class AbstractFragment<T : ViewBinding> : Fragment() {

    private var _binding: T? = null

    override fun onDestroyView() {
        (requireActivity() as Navigation).navigate(AddScreen)
        super.onDestroyView()
        _binding = null
    }
}