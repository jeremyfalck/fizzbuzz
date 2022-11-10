package com.jfalck.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jfalck.domain.common.exception.NullNumberException
import com.jfalck.domain.model.FizzBuzzPagingSource
import com.jfalck.domain.usecase.FizzBuzzValues.INITIAL_LOAD_SIZE
import com.jfalck.domain.usecase.FizzBuzzValues.PAGE_SIZE
import com.jfalck.domain.usecase.FizzBuzzValues.PREFETCH_DISTANCE
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@ViewModelScoped
class CalculateFizzBuzzUseCaseImpl @Inject constructor(
    private val dataSource: FizzBuzzPagingSource
) : CalculateFizzBuzzUseCase {

    override suspend fun invoke(firstNumber: Int?, secondNumber: Int?): Flow<PagingData<String>> {

        /*
        * The use case is responsible for applying the business logic.
        * This is why we check if the numbers are null here.
        * */
        if (firstNumber == null && secondNumber == null) {
            throw NullNumberException("Both numbers cannot be null")
        } else if (firstNumber == null) {
            throw NullNumberException("First number cannot be null")
        } else if (secondNumber == null) {
            throw NullNumberException("Second number cannot be null")
        }

        dataSource.firstNumber = firstNumber
        dataSource.secondNumber = secondNumber

        return Pager(config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE,
            initialLoadSize = INITIAL_LOAD_SIZE,
            enablePlaceholders = true,
        ), pagingSourceFactory = {
            dataSource
        }).flow
    }
}