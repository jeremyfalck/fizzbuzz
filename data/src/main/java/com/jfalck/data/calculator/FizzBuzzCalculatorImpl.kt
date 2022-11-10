package com.jfalck.data.calculator

import com.jfalck.domain.calculator.FizzBuzzCalculator
import com.jfalck.domain.usecase.FizzBuzzValues
import javax.inject.Inject

class FizzBuzzCalculatorImpl @Inject constructor() : FizzBuzzCalculator {

    // This function could totally change to use a different algorithm,
    // or call a fizz buzz API without impacting the rest of the app
    override fun calculate(firstNumber: Int?, secondNumber: Int?, page: Int): List<String> {
        val firstElement = FizzBuzzValues.PAGE_SIZE * (page - 1)

        return (firstElement until FizzBuzzValues.PAGE_SIZE * page).map {
            when {
                it % (firstNumber ?: 0) == 0 &&
                        it % (secondNumber ?: 0) == 0 -> FizzBuzzValues.FIZZBUZZ
                it % (firstNumber ?: 0) == 0 -> FizzBuzzValues.FIZZ
                it % (secondNumber ?: 0) == 0 -> FizzBuzzValues.BUZZ
                else -> it.toString()
            }
        }
    }
}