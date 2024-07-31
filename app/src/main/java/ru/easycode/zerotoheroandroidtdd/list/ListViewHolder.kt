package ru.easycode.zerotoheroandroidtdd.list

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ItemBinding
import ru.easycode.zerotoheroandroidtdd.databinding.ListFrameBinding

class ListViewHolder(val binding: ItemBinding):ViewHolder(binding.root) {

    fun bind(text:String){
        binding.elementTextView.text = text
    }
}