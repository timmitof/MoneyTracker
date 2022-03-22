package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.entities.Accounts

class AccountsAdapter(private val array: List<Accounts>, val context: FragmentActivity): RecyclerView.Adapter<AccountsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: FloatingActionButton = view.findViewById(R.id.icon_fab_btn)
        val title: TextView = view.findViewById(R.id.title_fab)
        val sum: TextView = view.findViewById(R.id.sum_fab)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fab_btn, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.icon.setImageResource(R.drawable.ic_transaction)
        holder.title.text = item.nameAccounts
        holder.sum.text = item.sumAccounts.toString()
    }

    override fun getItemCount(): Int {
        return array.size
    }
}