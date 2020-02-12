package com.sample.data.repository.di

import com.sample.data.repository.*
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { ReposRepositoryImpl(get(), get()) as ReposRepository }
    factory { UserRepositoryImpl(get(), get()) as UserRepository }
}