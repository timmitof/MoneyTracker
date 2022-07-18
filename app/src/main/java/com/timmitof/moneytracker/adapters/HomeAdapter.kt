package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.Constants.Companion.currency
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.databinding.ItemTransactionsBinding
import com.timmitof.moneytracker.models.Transaction

class HomeAdapter(private val array: List<Transaction>):RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemTransactionsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTransactionsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        if (item.type == 0) {
            holder.binding.transactionsTitle.text = item.category
            holder.binding.transactionsImage.setImageResource(item.image!!)
            holder.binding.transactionsImage.setColorFilter(holder.itemView.resources.getColor(R.color.green100))
            holder.binding.transactionsSum.text = "${item.sum} $currency"
            holder.binding.transactionsSum.setTextColor(holder.itemView.resources.getColor(R.color.green100))
        } else {
            holder.binding.transactionsTitle.text = item.category
            holder.binding.transactionsImage.setImageResource(item.image!!)
            holder.binding.transactionsImage.setColorFilter(holder.itemView.resources.getColor(R.color.red100))
            holder.binding.transactionsSum.text = "${item.sum} $currency"
            holder.binding.transactionsSum.setTextColor(holder.itemView.resources.getColor(R.color.red100))
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}