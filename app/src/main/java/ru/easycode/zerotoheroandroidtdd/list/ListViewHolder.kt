package ru.easycode.zerotoheroandroidtdd.list

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ItemBinding

class ListViewHolder(private val binding: ItemBinding) : ViewHolder(binding.root) {

    fun bind(text:String){
        binding.elementTextView.text = text
    }
}