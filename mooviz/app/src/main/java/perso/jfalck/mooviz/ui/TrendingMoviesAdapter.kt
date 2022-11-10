package perso.jfalck.mooviz.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import perso.jfalck.mooviz.databinding.TrendingMovieItemBinding

class TrendingMoviesAdapter :
    RecyclerView.Adapter<TrendingMoviesAdapter.TrendingMoviesViewHolder>() {

    private val movies = arrayListOf<MovieItem>()

    fun addMovies(newMovies: List<MovieItem>) {
        val previousIndex = if (movies.size == 0) 0 else movies.size - 1
        movies.addAll(newMovies)
        notifyItemRangeInserted(previousIndex, newMovies.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingMoviesViewHolder {
        val binding =
            TrendingMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendingMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingMoviesViewHolder, position: Int) {
        val movieItem = movies[position]
        holder.binding.tvMovieTitle.text = movieItem.title
        //TODO get Poster url and pass it
    }

    override fun getItemCount(): Int = movies.size

    inner class TrendingMoviesViewHolder(val binding: TrendingMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    data class MovieItem(
        val title: String,
        val posterUrl: String
    )
}