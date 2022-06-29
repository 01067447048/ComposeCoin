package com.jaehyeon.compose.composecoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jaehyeon.compose.composecoin.ui.components.CoinListScreen
import com.jaehyeon.compose.composecoin.ui.theme.ComposeCoinTheme
import com.jaehyeon.compose.composecoin.ui.viewmodel.CoinsViewModel
import com.jaehyeon.compose.composecoin.utils.NetworkStatusUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkStatus: NetworkStatusUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCoinTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val viewModel = viewModel<CoinsViewModel>()
                    CoinListScreen(viewModel)

                    networkStatus.observe(this) {
                        viewModel.getCoins()
                    }
                }
            }
        }


    }
}