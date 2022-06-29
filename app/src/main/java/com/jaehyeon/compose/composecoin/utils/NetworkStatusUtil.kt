package com.jaehyeon.compose.composecoin.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.LiveData
import javax.inject.Inject

/**
 * Created by Jaehyeon on 2022/06/29.
 */
class NetworkStatusUtil @Inject constructor(
    private val context: Context
): LiveData<Boolean>() {

    private var connectivityManager = context.getSystemService(ConnectivityManager::class.java)
    private var networkCallback: ConnectivityManager.NetworkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onLost(network: Network) {
            super.onLost(network)
            postValue(false)
        }

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            postValue(true)
        }
    }

    override fun onActive() {
        super.onActive()
        updateConnection()
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    private fun updateConnection() {
        val cap = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        postValue(cap != null)
    }

}