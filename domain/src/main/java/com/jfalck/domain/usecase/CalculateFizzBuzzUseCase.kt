package com.jfalck.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

/*
* Using an "abstraction" layer to respect the Dependency Inversion Principle
* */
interface CalculateFizzBuzzUseCase {
    suspend operator fun invoke(firstNumber: Int?, secondNumber: Int?): Flow<PagingData<String>>
}