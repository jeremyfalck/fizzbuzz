package perso.jfalck.mooviz.http

import perso.jfalck.mooviz.API_KEY
import perso.jfalck.mooviz.model.MoviesResults
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesService {
    @GET("discover/movie?sort_by=")
    suspend fun getPopularMovies(
        @Query("sort_by") sort: String = "popularity.desc",
        @Query("api_key") apiKey: String = API_KEY
    ): MoviesResults?
}