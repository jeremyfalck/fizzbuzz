package com.jfalck.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface CalculateFizzBuzzUseCase {
    suspend operator fun invoke(firstNumber: Int?, secondNumber: Int?): Flow<PagingData<String>>
}