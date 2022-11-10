package perso.jfalck.mooviz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import perso.jfalck.mooviz.interactor.GetTrendingMoviesInteractor
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    getTrendingMoviesInteractor: GetTrendingMoviesInteractor
) : ViewModel() {

    val moviesLiveData = getTrendingMoviesInteractor().asLiveData()
}
