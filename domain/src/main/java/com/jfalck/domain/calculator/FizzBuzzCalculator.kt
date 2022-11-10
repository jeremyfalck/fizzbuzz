package com.jfalck.domain.calculator

interface FizzBuzzCalculator {
    fun calculate(firstNumber: Int?, secondNumber: Int?, page: Int): List<String>
}