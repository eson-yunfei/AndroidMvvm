package com.shon.mvvm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 *
 * @Author xiao
 * @Date 2022-09-01 15:37
 *
 */
open class BaseViewModel : ViewModel() {

    open fun onAttach(lifecycleOwner: LifecycleOwner) {}


    /**
     * 在主线程中执行一个协程
     */
    protected fun launchOnMain(block: suspend CoroutineScope.() -> Unit): Job {

        return viewModelScope.launch(Dispatchers.Main) { block() }
    }

    /**
     * 在IO线程中执行一个协程：其实并不太需要，VM大部分时间是与UI的操作绑定，不太需要新起线程
     */
    protected fun launchOnIO(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(Dispatchers.IO) { block() }
    }
}