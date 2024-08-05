package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemDataBinding

class ViewHolder(val binding: ItemDataBinding):RecyclerView.ViewHolder(binding.root)
{
    fun bind(value:String){
        binding.elementTextView.text = value
    }
}