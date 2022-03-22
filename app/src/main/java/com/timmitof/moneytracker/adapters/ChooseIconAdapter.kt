package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.models.Icons

class ChooseIconAdapter(private val array: List<Icons>, val context: FragmentActivity): RecyclerView.Adapter<ChooseIconAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: FloatingActionButton = view.findViewById(R.id.choose_icon_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_choose_icon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.icon.setImageResource(item.srcIcon!!)
    }

    override fun getItemCount(): Int {
        return array.size
    }
}