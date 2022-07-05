package com.jaehyeon.compose.domain.repository

import com.jaehyeon.compose.domain.model.coin_detail.DomainCoinDetail
import io.reactivex.rxjava3.core.Single

/**
 * Created by Jaehyeon on 2022/07/06.
 */
interface CoinDetailRepository {

    fun getCoinDetail(id: String): Single<DomainCoinDetail>
}