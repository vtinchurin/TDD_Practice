package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TextItemBinding

class CustomViewAdapter:RecyclerView.Adapter<CustomViewHolder>() {

    private var data :ArrayList<CharSequence> = ArrayList()

    fun setData(list:ArrayList<CharSequence>){
        val du = DiffUtil(data,list)
        val diff = DiffUtil.calculateDiff(du)
        data.clear()
        data.addAll(list)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TextItemBinding.inflate(inflater)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}

private class DiffUtil(
    private val old:ArrayList<CharSequence>,
    private val new:ArrayList<CharSequence>):DiffUtil.Callback(){

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  old[oldItemPosition] == new[newItemPosition]
    }

}