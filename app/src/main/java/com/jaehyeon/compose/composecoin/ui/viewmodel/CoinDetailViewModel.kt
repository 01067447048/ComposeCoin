package com.jaehyeon.compose.composecoin.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jaehyeon.compose.composecoin.model.PresentationCoinDetail
import com.jaehyeon.compose.composecoin.use_case.CoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/07/06.
 */
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val detailUseCase: CoinDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Disposable 생성.
//    private val compositeDisposable by lazy(::CompositeDisposable)
    private val disposable = CompositeDisposable()

    data class CoinDetailState(
        val isLoading: Boolean = true,
        val detail: PresentationCoinDetail? = null,
        val error: String = ""
    )

    init {
        getCoinDetail()
    }

    var state by mutableStateOf(CoinDetailState())
        private set

    fun getCoinDetail() { // 실제 usecase 호출.
        Log.e(javaClass.simpleName, "getCoinDetail: Call")
        savedStateHandle.get<String>("coinId")?.let { id ->
            Log.e(javaClass.simpleName, "getCoinDetail: $id")
            // 아래 소스코드의 결과가 Disposable
            detailUseCase.invoke(id)
                .observeOn(AndroidSchedulers.mainThread()) // Rx의 MainScheduler 사용.
                .doOnError { t -> // 에러 발생시 처리
                    state = CoinDetailState(
                        error = t.localizedMessage ?: "알 수 없는 에러가 발생했습니다.",
                        isLoading = false
                    )
                }
                .subscribe({
                    // 실제 소비자. 소비자가 구독하면서 데이터가 발생을 하면 그 데이터를 소비하는 로직.
                    // Data 를 소비한다 = 데이터를 이용해서 추가 작업을 한다.
                    state = CoinDetailState(
                        isLoading = false,
                        detail = it
                    )
                }, { t2 ->
                    // 소비 하다 에러가 발생 했을 시.
                    state = CoinDetailState(
                        error = t2.localizedMessage ?: "알 수 없는 에러가 발생했습니다.",
                        isLoading = false
                    )
                }
                ).addTo(disposable)
        }
    }

    override fun onCleared() {
        super.onCleared()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }

}


