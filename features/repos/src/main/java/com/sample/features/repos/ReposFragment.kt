package com.sample.features.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.common.base.BaseFragment
import com.sample.common.base.BaseViewModel
import com.sample.features.repos.databinding.FragmentReposBinding
import com.sample.features.repos.ui.ReposAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class ReposFragment : BaseFragment() {

    private val viewModel: ReposViewModel by viewModel()
    private lateinit var binding: FragmentReposBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentReposBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        binding.fragmentReposRv.adapter = ReposAdapter(viewModel)
    }

    override fun getViewModel(): BaseViewModel = viewModel
}