package ru.easycode.zerotoheroandroidtdd.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemBinding

class ListAdapter():RecyclerView.Adapter<ListViewHolder>() {

    private var data = ArrayList<CharSequence>()

    fun update(list:List<CharSequence>){
        val du = DiffUtilUsage(data,list)
        val diff = DiffUtil.calculateDiff(du)
        data = ArrayList(list)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item.toString())
    }
}

class DiffUtilUsage(
    private val old:List<CharSequence>,
    private val new:List<CharSequence>
):DiffUtil.Callback() {
    override fun getOldListSize() = old.size


    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}