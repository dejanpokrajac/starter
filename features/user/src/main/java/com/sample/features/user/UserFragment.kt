package com.sample.features.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.common.base.BaseFragment
import com.sample.common.base.BaseViewModel
import com.sample.features.user.databinding.FragmentUserBinding
import org.koin.android.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment() {

    private val viewModel: UserViewModel by viewModel()
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun getViewModel(): BaseViewModel = viewModel
}
