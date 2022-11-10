package perso.jfalck.mooviz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import perso.jfalck.mooviz.databinding.FragmentDashboardBinding
import perso.jfalck.mooviz.ui.TrendingMoviesAdapter
import perso.jfalck.mooviz.viewmodel.MoviesViewModel

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val moviesViewModel by viewModels<MoviesViewModel>()

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val moviesAdapter: TrendingMoviesAdapter = TrendingMoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        observeLiveData()

        binding.rvTrendingMovies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = moviesAdapter
        }
    }

    private fun observeLiveData() =
        moviesViewModel.moviesLiveData.observe(viewLifecycleOwner, moviesAdapter::addMovies)


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}