package com.timmitof.moneytracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timmitof.moneytracker.App
import com.timmitof.moneytracker.databinding.ItemDeleteCategoryBinding
import com.timmitof.moneytracker.models.Category

class DeleteCategoryAdapter(private val array: ArrayList<Category>): RecyclerView.Adapter<DeleteCategoryAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemDeleteCategoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDeleteCategoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.binding.let {
            it.transactionsImage.setImageResource(item.icon!!)
            it.transactionsTitle.text = item.name
            it.deleteBtn.setOnClickListener {
                App.instance?.getDatabase()?.CategoryDao()?.deleteCategory(Category(item.id, item.name, item.icon, item.type))
                array.remove(item)
                notifyItemRemoved(position)
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}