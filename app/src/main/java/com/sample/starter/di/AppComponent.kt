package com.sample.starter.di

import com.sample.data.local.di.localModule
import com.sample.data.remote.di.createRemoteModule
import com.sample.data.repository.di.repositoryModule
import com.sample.features.repos.di.featureReposModule


val appComponent = listOf(
    createRemoteModule("https://api.github.com/"),
    repositoryModule,
    localModule,
    featureReposModule
)