package com.jfalck.domain.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jfalck.domain.calculator.FizzBuzzCalculator

class FizzBuzzPagingSource(
    private val calculator: FizzBuzzCalculator
) :
    PagingSource<Int, String>() {

    var firstNumber: Int? = null
    var secondNumber: Int? = null

    override fun getRefreshKey(state: PagingState<Int, String>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        val page = params.key ?: 1

        return try {
            val entity = calculator.calculate(firstNumber, secondNumber, page)
            toLoadResult(entity, page)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun toLoadResult(
        rawData: List<String>,
        page: Int
    ): LoadResult<Int, String> {
        return LoadResult.Page(
            data = rawData,
            prevKey = if (page == 1) null else page - 1,
            nextKey = page + 1
        )
    }
}