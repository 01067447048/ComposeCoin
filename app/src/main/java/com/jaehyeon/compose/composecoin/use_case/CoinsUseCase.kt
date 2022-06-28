package com.jaehyeon.compose.composecoin.use_case

import com.jaehyeon.compose.composecoin.model.PresentationCoin
import com.jaehyeon.compose.composecoin.model.toPresentationCoin
import com.jaehyeon.compose.composecoin.utils.Resource
import com.jaehyeon.compose.domain.repository.CoinListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/06/29.
 */
class CoinsUseCase @Inject constructor(
    private val repository: CoinListRepository
) {

    operator fun invoke(): Flow<Resource<List<PresentationCoin>>> = flow {
        try {
            emit(Resource.Loading<List<PresentationCoin>>())
            val coins = repository.getCoins().map { it.toPresentationCoin() }
            emit(Resource.Success<List<PresentationCoin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<PresentationCoin>>(e.localizedMessage ?: "알 수 없는 오류 입니다."))
        } catch (e: IOException) {
            emit(Resource.Error<List<PresentationCoin>>("서버와 연결 할 수 없습니다. 모바일 데이터나 Wi-Fi를 확인 해주세요."))
        }
    }
}