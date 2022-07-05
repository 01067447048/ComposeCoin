package com.jaehyeon.compose.data.data_source

import com.jaehyeon.compose.data.model.coin_detail.CoinDetailResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Jaehyeon on 2022/07/06.
 */
interface CoinDetailDataSource {

    @GET("/v1/coins/{coin_id}")
    fun getCoinDetail(
        @Path("coin_id")
        id: String
    ): Single<CoinDetailResponse> // 한 번의 이벤트를 발생 시킬 때는 Single 사용.
}