package com.jfalck.fizzbuzz.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jfalck.fizzbuzz.databinding.FragmentFizzBuzzListBinding
import com.jfalck.fizzbuzz.ui.adapter.FizzBuzzPagerAdapter
import com.jfalck.fizzbuzz.ui.viewmodel.FizzBuzzListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FizzBuzzListFragment : Fragment() {

    private val fizzBuzzListViewModel: FizzBuzzListViewModel by viewModels()

    private lateinit var binding: FragmentFizzBuzzListBinding

    // Single instance snackbar used to show error messages
    private lateinit var snackbar: Snackbar

    @Inject
    lateinit var adapter: FizzBuzzPagerAdapter

    private val doAfterTextChanged: (text: Editable?) -> Unit = {
        fizzBuzzListViewModel.calculateNewList(
            binding.fragmentFizzBuzzListFirstNumberInput.text.toString().toIntOrNull(),
            binding.fragmentFizzBuzzListSecondNumberInput.text.toString().toIntOrNull()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentFizzBuzzListBinding.inflate(layoutInflater).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeLiveDatas()
    }

    private fun observeLiveDatas() {
        fizzBuzzListViewModel.getErrorLiveData().observe(viewLifecycleOwner, ::showSnackbar)

        fizzBuzzListViewModel.getFizzBuzzPagingLiveData().observe(viewLifecycleOwner) {
            adapter.submitData(lifecycle, it)
        }
    }

    private fun initView() {
        snackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_SHORT)

        // When either field is changed, reloading the list
        binding.fragmentFizzBuzzListFirstNumberInput.doAfterTextChanged(doAfterTextChanged)
        binding.fragmentFizzBuzzListSecondNumberInput.doAfterTextChanged(doAfterTextChanged)

        initAdapter()
    }

    private fun initAdapter() {
        binding.fragmentFizzBuzzListRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = this@FizzBuzzListFragment.adapter
        }
    }

    private fun showSnackbar(message: String) =
        snackbar.setText(message).show()
}