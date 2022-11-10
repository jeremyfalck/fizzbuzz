package perso.jfalck.mooviz.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import perso.jfalck.mooviz.http.MoviesService
import perso.jfalck.mooviz.model.MoviesResults
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService
) : MoviesRepository {
    override suspend fun getStaticMovies(): ArrayList<String> =
        arrayListOf("La mémoire dans la peau", "John Wick", "Le sens de la fête")

    override fun getTrendingMovies(): Flow<MoviesResults?> = flow {
        emit(MoviesResults(0, listOf(), 0, 0))
        try {
            val movies = moviesService.getPopularMovies()
            emit(movies)
        } catch (throwable: Throwable) {
            Log.e("Movies", "Error retrieving trending movies")
        }
    }

}