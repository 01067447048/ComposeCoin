package com.jaehyeon.compose.domain.model

import com.google.gson.annotations.SerializedName

data class DomainCoin(
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

