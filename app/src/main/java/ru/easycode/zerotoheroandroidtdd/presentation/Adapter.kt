package ru.easycode.zerotoheroandroidtdd.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemDataBinding

class Adapter:RecyclerView.Adapter<ViewHolder>() {

    private var data = listOf<String>()

    fun update(list:List<String>){
        val du = DiffUtilUsage(data,list)
        val diff = DiffUtil.calculateDiff(du)
        data = ArrayList(list)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDataBinding.inflate(inflater)
        return ViewHolder(binding)

    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val value = data[position]
        holder.bind(value)
    }
}

private class DiffUtilUsage(
    private val old:List<CharSequence>,
    private val new:List<CharSequence>
): DiffUtil.Callback() {
    override fun getOldListSize() = old.size


    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}
