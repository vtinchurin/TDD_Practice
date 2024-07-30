package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementTextViewBinding

class CustomViewAdapter:RecyclerView.Adapter<CustomViewHolder>() {

    private var data = ArrayList<String>()

    fun getData():ArrayList<String>{
        return this.data
    }

    fun setData (data : ArrayList<String>){
        this.data = data
        notifyItemRangeChanged(0,data.size)
    }

    fun addItem(newData:String){
        data.add(newData)
        notifyItemInserted(data.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ElementTextViewBinding.inflate(inflater)
        return CustomViewHolder(binding = binding)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}