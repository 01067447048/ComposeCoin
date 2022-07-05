package com.jaehyeon.compose.domain.model.coin_detail

data class DomainCoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<DomainTeam>
)
