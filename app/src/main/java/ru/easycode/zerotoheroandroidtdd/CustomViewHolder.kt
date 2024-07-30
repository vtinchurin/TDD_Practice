package ru.easycode.zerotoheroandroidtdd

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.TextItemBinding

class CustomViewHolder(private val binding:TextItemBinding):ViewHolder(binding.root) {
    fun bind(text:CharSequence){
        binding.elementTextView.text = text
    }
}