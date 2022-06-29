package com.jaehyeon.compose.composecoin.di

import android.content.Context
import com.jaehyeon.compose.composecoin.utils.NetworkStatusUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilModule {

    @Provides
    @Singleton
    fun provideNetworkStatusUtil(
        @ApplicationContext
        context: Context
    ): NetworkStatusUtil {
        return NetworkStatusUtil(context)
    }
}