package com.jaehyeon.compose.data.data_source

import com.jaehyeon.compose.data.model.CoinListResponse
import retrofit2.http.GET

/**
 * Created by Jaehyeon on 2022/06/29.
 */
interface CoinListDataSource {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinListResponse>
}