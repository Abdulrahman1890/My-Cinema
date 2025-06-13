package com.example.mycinema.di

import com.example.mycinema.first_screen.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.mycinema.second_screen.viewmodel.MovieReservationViewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MovieReservationViewModel() }
    viewModel { HomeViewModel() }
}