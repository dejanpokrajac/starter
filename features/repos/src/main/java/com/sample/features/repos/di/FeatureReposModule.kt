package com.sample.features.repos.di

import com.sample.features.repos.ReposViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val featureReposModule = module {
    viewModel { ReposViewModel(get(), get()) }
}