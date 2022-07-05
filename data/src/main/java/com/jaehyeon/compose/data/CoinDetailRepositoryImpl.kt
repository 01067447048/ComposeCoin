package com.jaehyeon.compose.data

import com.jaehyeon.compose.data.data_source.CoinDetailDataSource
import com.jaehyeon.compose.data.model.coin_detail.toDomainCoinDetail
import com.jaehyeon.compose.domain.model.coin_detail.DomainCoinDetail
import com.jaehyeon.compose.domain.repository.CoinDetailRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/07/06.
 */
class CoinDetailRepositoryImpl @Inject constructor(
    private val api: CoinDetailDataSource
): CoinDetailRepository {

    // 마찬 가지로 한 번의 이벤트 발생하므로 Single 로 이벤트 생성
    // CoinResponse to DomainCoinDetail 로 mapping.
    // DataSource : CoinDetailResponse > Repository : DomainCoinDetail
    override fun getCoinDetail(id: String): Single<DomainCoinDetail> {
        return api.getCoinDetail(id).map {
            it.toDomainCoinDetail()
        }
    }
}