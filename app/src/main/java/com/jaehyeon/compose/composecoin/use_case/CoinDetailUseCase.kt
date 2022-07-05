package com.jaehyeon.compose.composecoin.use_case

import com.jaehyeon.compose.composecoin.model.PresentationCoinDetail
import com.jaehyeon.compose.composecoin.model.toPresentationCoinDetail
import com.jaehyeon.compose.domain.repository.CoinDetailRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/07/06.
 */
class CoinDetailUseCase @Inject constructor(
    private val repository: CoinDetailRepository
) {

    // 똑같이 Single 이벤트 발생시킴.
    // 그 후 PresentationCoinDetail 로 mapping
    // Repository : DomainCoinDetail > ViewModel : PresentationCoinDetail
    fun invoke(id: String): Single<PresentationCoinDetail> {
        return repository.getCoinDetail(id).map {
            it.toPresentationCoinDetail()
        }
    }
}