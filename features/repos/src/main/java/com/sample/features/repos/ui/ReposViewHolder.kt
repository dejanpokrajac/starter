package com.sample.features.repos.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sample.data.model.Repo
import com.sample.features.repos.ReposViewModel
import com.sample.features.repos.databinding.ItemRepoBinding

class ReposViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    private val binding = ItemRepoBinding.bind(parent)

    fun bindTo(repo: Repo, viewModel: ReposViewModel) {
        binding.repo = repo
        binding.viewmodel = viewModel
    }
}