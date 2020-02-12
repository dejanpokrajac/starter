package com.sample.data.repository

import androidx.lifecycle.LiveData
import com.sample.data.model.User
import com.sample.data.repository.utils.Resource

interface UserRepository {
    suspend fun getUser(forceRefresh: Boolean = false): LiveData<Resource<User>>
}