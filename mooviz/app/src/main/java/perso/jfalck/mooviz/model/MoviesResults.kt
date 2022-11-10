package perso.jfalck.mooviz.model

data class MoviesResults(
    var page: Int,
    var results: List<Movie>,
    var total_pages: Int,
    var total_results: Int
)