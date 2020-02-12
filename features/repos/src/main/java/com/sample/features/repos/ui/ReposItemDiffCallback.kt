package com.sample.features.repos.ui

import androidx.recyclerview.widget.DiffUtil
import com.sample.data.model.Repo

class ReposItemDiffCallback(private val oldList: List<Repo>,
                            private val newList: List<Repo>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].name == newList[newItemPosition].name
    }
}