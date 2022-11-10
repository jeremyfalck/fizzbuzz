package perso.jfalck.mooviz.repository

import kotlinx.coroutines.flow.Flow
import perso.jfalck.mooviz.model.MoviesResults
import retrofit2.Response

interface MoviesRepository {
    suspend fun getStaticMovies(): ArrayList<String>
    fun getTrendingMovies(): Flow<MoviesResults?>
}