package com.sample.data.repository

import androidx.lifecycle.LiveData
import com.sample.data.local.dao.UserDao
import com.sample.data.model.User
import com.sample.data.remote.UserDataSource
import com.sample.data.repository.utils.NetworkBoundResource
import com.sample.data.repository.utils.Resource
import kotlinx.coroutines.Deferred

class UserRepositoryImpl(private val dataSource: UserDataSource,
                         private val dao: UserDao
): UserRepository {

    override suspend fun getUser(forceRefresh: Boolean): LiveData<Resource<User>> {
        return object : NetworkBoundResource<User, User>() {

            override fun processResponse(response: User): User
                    = response

            override suspend fun saveCallResults(data: User) = dao.save(data)

            override fun shouldFetch(data: User?): Boolean
                    = data == null
                    || data.refreshFromNetwork()
                    || forceRefresh

            override suspend fun loadFromDb(): User
                    = dao.getUser()

            override fun createCallAsync(): Deferred<User>
                    = dataSource.getUser()

        }.build().asLiveData()
    }
}