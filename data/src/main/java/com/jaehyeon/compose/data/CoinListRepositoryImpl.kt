package com.jaehyeon.compose.data

import com.jaehyeon.compose.data.data_source.CoinListDataSource
import com.jaehyeon.compose.data.model.toDomainCoin
import com.jaehyeon.compose.domain.model.DomainCoin
import com.jaehyeon.compose.domain.repository.CoinListRepository
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/06/29.
 */
class CoinListRepositoryImpl @Inject constructor(
    private val api: CoinListDataSource
): CoinListRepository {

    override suspend fun getCoins(): List<DomainCoin> {
        return api.getCoins().filter { it.type == "coin" }.map { it.toDomainCoin() }
    }

}