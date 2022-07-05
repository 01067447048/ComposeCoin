package com.jaehyeon.compose.composecoin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jaehyeon.compose.composecoin.ui.components.coin_detail.CoinDetailScreen
import com.jaehyeon.compose.composecoin.ui.components.coin_list.CoinListScreen
import com.jaehyeon.compose.composecoin.ui.screen.Screen
import com.jaehyeon.compose.composecoin.ui.theme.ComposeCoinTheme
import com.jaehyeon.compose.composecoin.ui.viewmodel.CoinDetailViewModel
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
                    val navController = rememberNavController()
                    val listViewModel = viewModel<CoinsViewModel>()
                    val detailViewModel = viewModel<CoinDetailViewModel>()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }

                    networkStatus.observe(this) {
                        when(navController.currentDestination?.route) {
                            "coin_list_screen" -> {
                                listViewModel.getCoins()
                            }

                            "coin_detail_screen/{coinId}" -> {
                                detailViewModel.getCoinDetail()
                            }

                            else -> {
                                Log.e("TAG", "onCreate: ${navController.currentDestination?.route}")
                            }
                        }
                    }

                }
            }
        }
    }
}