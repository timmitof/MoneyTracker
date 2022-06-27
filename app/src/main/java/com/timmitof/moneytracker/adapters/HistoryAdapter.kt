package com.timmitof.moneytracker.adapters

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.databinding.ItemTransactionsBinding
import com.timmitof.moneytracker.models.Transaction

class HistoryAdapter(private val array: List<Transaction>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemTransactionsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTransactionsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        if (item.type == 0) {
            holder.binding.let {
                it.transactionsTitle.text = item.category
                it.transactionsImage.setImageResource(item.image!!)
                it.transactionsImage.setColorFilter(holder.itemView.resources.getColor(R.color.green100))
                it.transactionsSum.text = item.sum.toString()
                it.transactionsSum.setTextColor(holder.itemView.resources.getColor(R.color.green100))
            }
        } else {
            holder.binding.let {
                it.transactionsTitle.text = item.category
                it.transactionsImage.setImageResource(item.image!!)
                it.transactionsImage.setColorFilter(holder.itemView.resources.getColor(R.color.red100))
                it.transactionsSum.text = item.sum.toString()
                it.transactionsSum.setTextColor(holder.itemView.resources.getColor(R.color.red100))
            }
        }
    }


    override fun getItemCount(): Int {
        return array.size
    }
}
