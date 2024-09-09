package com.example.domain.di

import com.example.domain.usescase.DeleteTaskUseCase
import com.example.domain.usescase.FetchTaskUseCase
import com.example.domain.usescase.GetTaskUseCase
import com.example.domain.usescase.InsertTaskUseCase
import org.koin.dsl.module

val usesCaseModule = module {
    factory { DeleteTaskUseCase(get()) }
    factory { InsertTaskUseCase(get()) }
    factory { FetchTaskUseCase(get()) }
    factory { GetTaskUseCase(get()) }
}