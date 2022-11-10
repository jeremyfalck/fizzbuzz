package com.jfalck.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
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
) :
    CalculateFizzBuzzUseCase {

    override suspend fun invoke(firstNumber: Int?, secondNumber: Int?): Flow<PagingData<String>> {

        dataSource.firstNumber = firstNumber
        dataSource.secondNumber = secondNumber

        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
                initialLoadSize = INITIAL_LOAD_SIZE,
                enablePlaceholders = true,
            ),
            pagingSourceFactory = {
                dataSource
            }
        ).flow
    }
}