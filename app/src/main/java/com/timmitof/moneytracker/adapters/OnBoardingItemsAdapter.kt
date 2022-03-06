package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.models.OnBoardingItem

class OnBoardingItemsAdapter(private val array: List<OnBoardingItem>): RecyclerView.Adapter<OnBoardingItemsAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.onBoardingImage)
        val mainInfo = view.findViewById<TextView>(R.id.onBoardingMainInfo)
        val secondInfo = view.findViewById<TextView>(R.id.onBoardingSecondInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.onboarding_item_container, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.image.setImageResource(item.onBoardingImage)
        holder.mainInfo.text = item.onBoardingTitle.toString()
        holder.secondInfo.text = item.onBoardingDescription.toString()
    }

    override fun getItemCount(): Int {
        return array.size
    }
}