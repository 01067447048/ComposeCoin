package com.jaehyeon.compose.composecoin.model

import com.jaehyeon.compose.domain.model.DomainCoin

data class PresentationCoin(
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

fun DomainCoin.toPresentationCoin(): PresentationCoin =
    PresentationCoin(
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank,
        symbol = symbol
    )