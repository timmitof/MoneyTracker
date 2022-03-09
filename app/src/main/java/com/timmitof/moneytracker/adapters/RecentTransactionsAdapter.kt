package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.models.RecentTransaction

class RecentTransactionsAdapter(private val array: ArrayList<RecentTransaction>): RecyclerView.Adapter<RecentTransactionsAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.recent_transaction_title)
        var description: TextView = view.findViewById(R.id.recent_transaction_description)
        var sum: TextView = view.findViewById(R.id.recent_transaction_sum)
        var time: TextView = view.findViewById(R.id.recent_transaction_time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.recent_transactions_item_cell, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = array[position]
        holder.title.text = item.title
        holder.description.text = item.description
        holder.sum.text = item.sum.toString()
        holder.time.text = item.time
    }

    override fun getItemCount(): Int {
        return array.size
    }
}