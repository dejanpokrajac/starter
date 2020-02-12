package com.sample.data.remote

import com.sample.data.model.Repo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ReposService {

    @GET("users/octocat/repos")
    fun getRepos(): Deferred<List<Repo>>
}