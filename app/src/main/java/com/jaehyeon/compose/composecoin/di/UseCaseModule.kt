package com.jaehyeon.compose.composecoin.di

import com.jaehyeon.compose.composecoin.use_case.CoinDetailUseCase
import com.jaehyeon.compose.composecoin.use_case.CoinsUseCase
import com.jaehyeon.compose.domain.repository.CoinDetailRepository
import com.jaehyeon.compose.domain.repository.CoinListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCoinListUseCase(
        repository: CoinListRepository
    ): CoinsUseCase {
        return CoinsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCoinDetailUseCase(
        repository: CoinDetailRepository
    ): CoinDetailUseCase {
        return CoinDetailUseCase(repository)
    }

}