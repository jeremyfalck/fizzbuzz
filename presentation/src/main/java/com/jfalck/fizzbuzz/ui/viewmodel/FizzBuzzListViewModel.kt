package com.jfalck.fizzbuzz.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jfalck.domain.usecase.CalculateFizzBuzzUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class FizzBuzzListViewModel @Inject constructor(private val calculateFizzBuzzUseCase: CalculateFizzBuzzUseCase) :
    ViewModel(), CoroutineScope by CoroutineScope(
    Dispatchers.IO
) {

    private val fizzBuzzPagingLiveData = MutableLiveData<PagingData<String>>()

    private val errorLiveData: MutableLiveData<String> = MutableLiveData()

    fun getFizzBuzzPagingLiveData(): LiveData<PagingData<String>> = fizzBuzzPagingLiveData
    fun getErrorLiveData(): LiveData<String> = errorLiveData


    fun calculateNewList(firstNumber: Int?, secondNumber: Int?) {

        launch {
            try {
                calculateFizzBuzzUseCase.invoke(firstNumber, secondNumber).cachedIn(this)
                    .collect(fizzBuzzPagingLiveData::postValue)
            } catch (e: Exception) {
                errorLiveData.postValue(e.message)
            }
        }
    }
}