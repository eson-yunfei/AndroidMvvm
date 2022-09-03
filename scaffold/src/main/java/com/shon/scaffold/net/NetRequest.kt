package com.shon.scaffold.net

import com.shon.scaffold.net.exception.NetError
import com.shon.scaffold.net.exception.handleThrowable
import com.shon.scaffold.net.response.NetResponse
import kotlinx.coroutines.*

/**
 *
 * @Author xiao
 * @Date 2022-09-02 15:01
 *
 */
interface NetRequest<API> {

    fun getAPI(): API
    fun <T> requestData(
        block: suspend () -> NetResponse<T>,
        onResponse: (T?) -> Unit,
        timeDelay: Long = 500L,
        onShowLoading: () -> Unit = {}
    ) {
        launchRequestOnIO(block, timeDelay, onShowLoading, onRequestSuccess = {
            if (it.isResponseSuccess()) {
                MainScope().launch {
                    onResponse.invoke(it.getResponseData())
                }
            }
        }) {

        }
    }

    fun requestBoolean(
        block: suspend () -> NetResponse<Any>,
        onResponse: (Boolean?) -> Unit,
        timeDelay: Long = 500L,
        onShowLoading: () -> Unit = {}
    ) {
        launchRequestOnIO(block, timeDelay, onShowLoading, onRequestSuccess = {
            MainScope().launch {
                onResponse.invoke(it.isResponseSuccess())
            }
        }) {

        }
    }


    private fun <T> launchRequestOnIO(
        block: suspend () -> NetResponse<T>,
        timeDelay: Long, onShowLoading: () -> Unit,
        onRequestSuccess: (NetResponse<T>) -> Unit,
        onRequestError: (NetError) -> Unit
    ) {
        val showDialog: Job = delayShowDialog(timeDelay, onShowLoading)
        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
                block()
            }.onSuccess {
                showDialog.cancel()
                onRequestSuccess.invoke(it)
            }.onFailure {
                showDialog.cancel()
                val handleThrowable = it.handleThrowable()
                onRequestError.invoke(handleThrowable)
            }
        }

    }

    private fun delayShowDialog(timeDelay: Long, onShowLoading: () -> Unit): Job {
        return MainScope().launch(Dispatchers.Main) {
            delay(timeDelay)
            onShowLoading.invoke()
        }
    }
}