package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.databinding.ItemChooseIconBinding
import com.timmitof.moneytracker.models.Icons

class ChooseIconAdapter(private val array: List<Icons>): RecyclerView.Adapter<ChooseIconAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemChooseIconBinding): RecyclerView.ViewHolder(binding.root)

    private var onItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChooseIconBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.binding.addCategoryImage.setImageResource(item.image)
        holder.binding.addCategoryImage.setOnClickListener {
            onItemClickListener?.let { it(array[position].image) }
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }
}