package com.sample.data.remote

import com.sample.data.model.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface UserService {

    @GET("users/octocat")
    fun getUser(): Deferred<User>
}