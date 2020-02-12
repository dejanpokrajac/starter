package com.sample.data.repository.di

import com.sample.data.repository.AppDispatchers
import com.sample.data.repository.ReposRepository
import com.sample.data.repository.ReposRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { ReposRepositoryImpl(get(), get()) as ReposRepository }
}