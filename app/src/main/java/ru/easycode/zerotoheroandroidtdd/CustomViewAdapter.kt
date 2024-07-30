package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TextItemBinding
import java.util.zip.Inflater

class CustomViewAdapter:RecyclerView.Adapter<CustomViewHolder>() {

    private var data :ArrayList<CharSequence> = ArrayList()
    fun setData(list:ArrayList<CharSequence>){
        data = list
        //notifyItemRangeChanged(0,list.size)
        notifyDataSetChanged()
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