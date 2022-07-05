package com.jaehyeon.compose.composecoin.model

import com.jaehyeon.compose.domain.model.coin_detail.DomainCoinDetail
import com.jaehyeon.compose.domain.model.coin_detail.DomainTeam

data class PresentationCoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<DomainTeam> // 원래 PresentationTeam을 만드는게 정석이지만 귀찮음.
)

fun DomainCoinDetail.toPresentationCoinDetail(): PresentationCoinDetail {
    return PresentationCoinDetail(
        coinId, name, description, symbol, rank, isActive, tags, team
    )
}