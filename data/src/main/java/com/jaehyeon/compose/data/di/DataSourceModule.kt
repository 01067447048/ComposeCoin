package com.jaehyeon.compose.data.di

import com.jaehyeon.compose.data.data_source.CoinListDataSource
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
    fun provideConListDataSource(
        retrofit: Retrofit
    ): CoinListDataSource {
        return CoinListDataSourceImpl(retrofit)
    }

}