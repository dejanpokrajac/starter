package com.sample.features.user.di

import com.sample.features.user.UserViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val featureUserModule = module {
    viewModel { UserViewModel(get(), get()) }
}