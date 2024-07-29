package ru.easycode.zerotoheroandroidtdd

import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementTextViewBinding

class CustomViewHolder(val binding:ElementTextViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(source:String){
        binding.elementTextView.text = source
    }
}