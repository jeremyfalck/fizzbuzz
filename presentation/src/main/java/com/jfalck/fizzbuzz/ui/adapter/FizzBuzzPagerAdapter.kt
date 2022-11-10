package com.jfalck.fizzbuzz.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jfalck.fizzbuzz.databinding.FizzBuzzItemBinding
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import kotlin.random.Random

@FragmentScoped
class FizzBuzzPagerAdapter @Inject constructor() :
    PagingDataAdapter<String, FizzBuzzPagerAdapter.FizzBuzzViewHolder>(FizzBuzzDiffCallback()) {

    private var lastPosition = -1

    inner class FizzBuzzViewHolder(val binding: FizzBuzzItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: FizzBuzzViewHolder, position: Int) {
        setAnimation(holder.itemView, position)
        getItem(position)?.let { item ->
            bindItem(holder, item)
        }
    }

    private fun bindItem(holder: FizzBuzzViewHolder, item: String) {
        holder.binding.fizzBuzzItemText.text = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FizzBuzzViewHolder =
        FizzBuzzViewHolder(
            FizzBuzzItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = Random.nextLong(501) //to make duration random number between [0,501])
            viewToAnimate.startAnimation(anim)
            lastPosition = position
        }
    }
}