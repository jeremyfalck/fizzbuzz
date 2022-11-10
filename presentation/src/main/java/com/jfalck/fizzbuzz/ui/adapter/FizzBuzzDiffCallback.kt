package com.jfalck.fizzbuzz.ui.adapter

import androidx.recyclerview.widget.DiffUtil

/*
* A diff util is necessary when using a recycler view with a paging data adapter.
* Here both methods do the same thing as the elements compared are simple strings
*
* In more complex cases, the areContentsTheSame method would be more dense
* */
class FizzBuzzDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}