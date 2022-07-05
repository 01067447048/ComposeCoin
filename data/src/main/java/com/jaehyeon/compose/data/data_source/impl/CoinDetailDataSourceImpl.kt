package com.jaehyeon.compose.data.data_source.impl

import com.jaehyeon.compose.data.data_source.CoinDetailDataSource
import com.jaehyeon.compose.data.di.RxRetrofit
import com.jaehyeon.compose.data.model.coin_detail.CoinDetailResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/07/06.
 */
class CoinDetailDataSourceImpl @Inject constructor(
    @RxRetrofit
    private val retrofit: Retrofit
): CoinDetailDataSource {

    // Single 로 이벤트 발생.
    // CoinDetailResponse 를 받는 endpoint
    override fun getCoinDetail(id: String): Single<CoinDetailResponse> {
        return retrofit.create(CoinDetailDataSource::class.java).getCoinDetail(id)
    }

}