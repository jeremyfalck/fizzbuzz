package perso.jfalck.mooviz.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import perso.jfalck.mooviz.repository.MoviesRepository
import perso.jfalck.mooviz.ui.TrendingMoviesAdapter
import javax.inject.Inject


class GetTrendingMoviesInteractor @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(): Flow<List<TrendingMoviesAdapter.MovieItem>> =
        moviesRepository.getTrendingMovies().map { moviesResults ->
            (moviesResults?.results?.map { it.title } ?: listOf<String>()).sortedBy { it }.map {
                TrendingMoviesAdapter.MovieItem(it ?: "", "")
            }
        }
}