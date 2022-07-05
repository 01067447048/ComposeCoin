package com.jaehyeon.compose.data.di

import com.jaehyeon.compose.data.CoinDetailRepositoryImpl
import com.jaehyeon.compose.data.CoinListRepositoryImpl
import com.jaehyeon.compose.data.data_source.CoinDetailDataSource
import com.jaehyeon.compose.data.data_source.CoinListDataSource
import com.jaehyeon.compose.domain.repository.CoinDetailRepository
import com.jaehyeon.compose.domain.repository.CoinListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinListRepository(
        coinListDataSource: CoinListDataSource
    ): CoinListRepository {
        return CoinListRepositoryImpl(coinListDataSource)
    }

    @Provides
    @Singleton
    fun provideCoinDetailRepository(
        coinDetailDataSource: CoinDetailDataSource
    ): CoinDetailRepository {
        return CoinDetailRepositoryImpl(coinDetailDataSource)
    }
}