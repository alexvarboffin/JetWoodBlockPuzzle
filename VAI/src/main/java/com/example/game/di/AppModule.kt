package com.example.game.di

import com.example.game.data.datasource.LocalDataSource
import com.example.game.data.repository.GameRepositoryImpl
import com.example.game.presentation.screens.game.GameViewModel
import com.example.game.presentation.screens.home.HomeViewModel
import com.example.game.presentation.screens.splash.SplashViewModel
import com.vai.vaidebet.vaibrazil.data.repository.UserProgressRepositoryImpl
import com.walhalla.sdk.domain.repository.GameRepository
import com.walhalla.sdk.domain.repository.UserProgressRepository
import com.walhalla.sdk.domain.usecase.GetLevelUseCase
import com.walhalla.sdk.domain.usecase.GetLevelsUseCase
import com.walhalla.sdk.domain.usecase.GetTotalLevelsUseCase
import com.walhalla.sdk.domain.usecase.GetUserProgressUseCase
import com.walhalla.sdk.domain.usecase.UpdateHighestUnlockedLevelUseCase
import com.walhalla.sdk.domain.usecase.UpdateStarsUseCase

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { LocalDataSource(androidContext()) }
    single<GameRepository> { GameRepositoryImpl(get()) }
    single<UserProgressRepository> { UserProgressRepositoryImpl(androidContext()) }
    factory { GetLevelsUseCase(get()) }
    factory { GetLevelUseCase(get()) }
    factory { GetTotalLevelsUseCase(get()) }
    factory { GetUserProgressUseCase(get()) }
    factory { UpdateHighestUnlockedLevelUseCase(get()) }
    factory { UpdateStarsUseCase(get()) }

    viewModel { SplashViewModel() }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { params ->
        GameViewModel(
            getLevelUseCase = get<GetLevelUseCase>(), // Explicitly specify type
            getTotalLevelsUseCase = get<GetTotalLevelsUseCase>(), // Explicitly specify type
            updateHighestUnlockedLevelUseCase = get<UpdateHighestUnlockedLevelUseCase>(), // Explicitly specify type
            updateStarsUseCase = get<UpdateStarsUseCase>(), // Explicitly specify type
            savedStateHandle = params.get()
        )
    }
}
