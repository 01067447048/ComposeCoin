package com.jaehyeon.compose.data.di

import com.jaehyeon.compose.data.data_source.CoinDetailDataSource
import com.jaehyeon.compose.data.data_source.CoinListDataSource
import com.jaehyeon.compose.data.data_source.impl.CoinDetailDataSourceImpl
import com.jaehyeon.compose.data.data_source.impl.CoinListDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideCoinListDataSource(
        @CoroutineRetrofit
        retrofit: Retrofit
    ): CoinListDataSource {
        return CoinListDataSourceImpl(retrofit)
    }

    @Provides
    @Singleton
    fun provideCoinDetailDataSource(
        @RxRetrofit
        retrofit: Retrofit
    ): CoinDetailDataSource {
        return CoinDetailDataSourceImpl(retrofit)
    }

}