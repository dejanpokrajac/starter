package com.sample.data.repository

import androidx.lifecycle.LiveData
import com.sample.data.local.dao.ReposDao
import com.sample.data.model.Repo
import com.sample.data.remote.ReposDataSource
import com.sample.data.repository.utils.NetworkBoundResource
import com.sample.data.repository.utils.Resource
import kotlinx.coroutines.Deferred

class ReposRepositoryImpl(private val dataSource: ReposDataSource,
                          private val dao: ReposDao): ReposRepository {

    override suspend fun getRepos(forceRefresh: Boolean): LiveData<Resource<List<Repo>>> {
        return object : NetworkBoundResource<List<Repo>, List<Repo>>() {

            override fun processResponse(response: List<Repo>): List<Repo> = response

            override suspend fun saveCallResults(data: List<Repo>) = dao.insert(data)

            override fun shouldFetch(data: List<Repo>?): Boolean
                    = data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<Repo>
                    = dao.getRepos()

            override fun createCallAsync(): Deferred<List<Repo>>
                    = dataSource.getRepos()

        }.build().asLiveData()
    }
}