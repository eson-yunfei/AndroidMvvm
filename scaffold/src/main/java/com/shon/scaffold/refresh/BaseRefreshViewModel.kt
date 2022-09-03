package com.shon.scaffold.refresh

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.shon.scaffold.net.BaseNetViewModel

abstract class BaseRefreshViewModel<T, API> : BaseNetViewModel<API>() {

    protected val refreshLiveData: MutableLiveData<MutableList<T>?> = MutableLiveData()

    protected var refreshView: OnRefreshView<T>? = null


    override fun onAttach(lifecycleOwner: LifecycleOwner) {

        refreshLiveData.observe(lifecycleOwner, this::onRefreshData)

    }

    fun setOnRefreshView(view: OnRefreshView<T>) {
        refreshView = view
    }

    private fun onRefreshData(list: MutableList<T>?) {
        list ?: kotlin.run { onNoData() }
        list?.let {
            if (it.isEmpty()) {
                onNoData()
            } else {
                refreshDataList(it)
            }
        }

    }

    private fun onNoData() {
        refreshView?.onNoData()
    }

    private fun refreshDataList(list: MutableList<T>) {
        refreshView?.onRefreshData(list)
        upgradePageIndex()
    }

    open fun upgradePageIndex(){

    }
}