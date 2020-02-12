package com.sample.data.remote

class ReposDataSource(private val reposService: ReposService) {

    fun getRepos() = reposService.getRepos()
}