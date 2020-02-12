package com.sample.data.repository

import androidx.lifecycle.LiveData
import com.sample.data.model.Repo
import com.sample.data.repository.utils.Resource

interface ReposRepository {
    suspend fun getRepos(forceRefresh: Boolean = false): LiveData<Resource<List<Repo>>>
}