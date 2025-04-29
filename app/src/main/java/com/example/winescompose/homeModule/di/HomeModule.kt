package com.example.winescompose.homeModule.di

import com.example.winescompose.homeModule.model.HomeRepository
import com.example.winescompose.homeModule.model.domain.HomeRoomDatabase
import com.example.winescompose.homeModule.model.domain.HomeWineService
import com.example.winescompose.homeModule.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory { HomeRoomDatabase(get()) }
    factory { HomeWineService(get()) }
    factory { HomeRepository(get(), get()) }
    viewModel { HomeViewModel(get()) }
}