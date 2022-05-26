package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.databinding.ItemOnboardingViewpagerBinding
import com.timmitof.moneytracker.models.OnBoardingItem

class OnBoardingItemAdapter(private val array: List<OnBoardingItem>): RecyclerView.Adapter<OnBoardingItemAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemOnboardingViewpagerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOnboardingViewpagerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.binding.onBoardingImage.setImageResource(item.image)
        holder.binding.title.text = item.title
        holder.binding.description.text = item.description
    }

    override fun getItemCount(): Int {
        return array.size
    }
}