package com.jaehyeon.compose.composecoin.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaehyeon.compose.composecoin.model.PresentationCoin
import com.jaehyeon.compose.composecoin.use_case.CoinsUseCase
import com.jaehyeon.compose.composecoin.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/06/29.
 */
@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val useCase: CoinsUseCase
): ViewModel() {

    data class CoinsState(
        val isLoading: Boolean = false,
        val coins: List<PresentationCoin> = emptyList(),
        val error: String = ""
    )

    var state by mutableStateOf(CoinsState())
        private set

    fun getCoins() {
        useCase().onEach { result ->
            state = when (result) {
                is Resource.Success -> {
                    CoinsState(coins = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    CoinsState(error = result.message)
                }

                is Resource.Loading -> {
                    CoinsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    init {
        getCoins()
    }
}