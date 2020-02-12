package com.sample.features.repos.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.data.model.Repo
import com.sample.features.repos.R
import com.sample.features.repos.ReposViewModel

class ReposAdapter(private val viewModel: ReposViewModel) :
    RecyclerView.Adapter<ReposViewHolder>() {

    private val repos: MutableList<Repo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ReposViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_repo,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) =
        holder.bindTo(repos[position], viewModel)

    fun updateData(items: List<Repo>) {
        val diffCallback = ReposItemDiffCallback(repos, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        repos.clear()
        repos.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }
}