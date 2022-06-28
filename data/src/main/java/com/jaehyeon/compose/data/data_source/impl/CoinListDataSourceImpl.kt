package com.jaehyeon.compose.data.data_source.impl

import com.jaehyeon.compose.data.data_source.CoinListDataSource
import com.jaehyeon.compose.data.model.CoinListResponse
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/06/29.
 */
class CoinListDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
): CoinListDataSource {

    override suspend fun getCoins(): List<CoinListResponse> {
        return retrofit.create(CoinListDataSource::class.java).getCoins()
    }

}