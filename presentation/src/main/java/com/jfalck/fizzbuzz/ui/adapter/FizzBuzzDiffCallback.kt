package com.jfalck.fizzbuzz.ui.adapter

import androidx.recyclerview.widget.DiffUtil

class FizzBuzzDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}