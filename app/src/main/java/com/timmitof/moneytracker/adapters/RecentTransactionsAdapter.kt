package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.entities.Spend

class RecentTransactionsAdapter(private val array: List<Spend>, val context: FragmentActivity): RecyclerView.Adapter<RecentTransactionsAdapter.ViewHolder>(){
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
        val item = array[position]
        holder.title.text = item.titleSpend
        holder.description.text = item.descriptionSpend
        holder.sum.text = item.sumSpend.toString()
        holder.time.text = item.timeSpend
    }

    override fun getItemCount(): Int {
        return array.size
    }
}