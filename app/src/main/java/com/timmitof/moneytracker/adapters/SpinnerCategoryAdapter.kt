package com.timmitof.moneytracker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.timmitof.moneytracker.R
import com.timmitof.moneytracker.models.Category

class SpinnerCategoryAdapter(context: Context, categoryList: List<Category>) : ArrayAdapter<Category>(context, 0, categoryList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val category = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_category, parent, false)
        val image = view.findViewById<ImageView>(R.id.category_image)
        val name = view.findViewById<TextView>(R.id.category_name)

        image.setImageResource(category?.icon!!)
        name.text = category.name

        return view
    }
}