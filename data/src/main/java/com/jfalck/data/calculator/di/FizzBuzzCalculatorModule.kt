package com.jfalck.data.calculator.di

import com.jfalck.data.calculator.FizzBuzzCalculatorImpl
import com.jfalck.domain.calculator.FizzBuzzCalculator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FizzBuzzCalculatorModule {

    @Singleton
    @Provides
    fun providesFizzBuzzCalculatorModule(): FizzBuzzCalculator = FizzBuzzCalculatorImpl()
}