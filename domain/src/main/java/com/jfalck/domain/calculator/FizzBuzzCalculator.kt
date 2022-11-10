package com.jfalck.domain.calculator

/*
* Using an "abstraction" layer to respect the Dependency Inversion Principle
* */
interface FizzBuzzCalculator {
    fun calculate(firstNumber: Int?, secondNumber: Int?, page: Int): List<String>
}