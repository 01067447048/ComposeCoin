package com.jaehyeon.compose.domain.repository

import com.jaehyeon.compose.domain.model.DomainCoin

/**
 * Created by Jaehyeon on 2022/06/29.
 */
interface CoinListRepository {

    suspend fun getCoins(): List<DomainCoin>
}