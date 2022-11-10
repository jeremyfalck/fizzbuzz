package com.jfalck.fizzbuzz.di

import com.jfalck.data.calculator.di.FizzBuzzCalculatorModule
import com.jfalck.domain.calculator.FizzBuzzCalculator
import com.jfalck.domain.model.FizzBuzzPagingSource
import com.jfalck.domain.usecase.CalculateFizzBuzzUseCase
import com.jfalck.domain.usecase.CalculateFizzBuzzUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module(includes = [FizzBuzzCalculatorModule::class])
@InstallIn(SingletonComponent::class)
object CalculateFizzBuzzUseCaseModule {

    @Singleton
    @Provides
    fun providesFizzBuzzPagingSource(calculator: FizzBuzzCalculator) =
        FizzBuzzPagingSource(calculator)

    @Singleton
    @Provides
    fun provideCalculateFizzBuzzUseCaseModule(
        fizzBuzzPagingSource: FizzBuzzPagingSource
    ): CalculateFizzBuzzUseCase =
        CalculateFizzBuzzUseCaseImpl(fizzBuzzPagingSource)
}