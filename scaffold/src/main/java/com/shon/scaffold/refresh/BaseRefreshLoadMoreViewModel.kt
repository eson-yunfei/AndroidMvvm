package com.shon.scaffold.refresh

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

abstract class BaseRefreshLoadMoreViewModel<T, API> : BaseRefreshViewModel<T, API>() {

    protected val loadMoreLiveData: MutableLiveData<MutableList<T>?> = MutableLiveData()

    override fun onAttach(lifecycleOwner: LifecycleOwner) {
        super.onAttach(lifecycleOwner)
        loadMoreLiveData.observe(lifecycleOwner, this::onLoadMoreData)
    }

    fun setOnRefreshLoadMoreView(view: OnRefreshLoadMoreView<T>) {
        refreshView = view
    }

    private fun onLoadMoreData(list: MutableList<T>?) {
        list ?: kotlin.run { onNoMoreData() }
        list?.let {
            if (it.isEmpty()) {
                onNoMoreData()
            } else {
                morData(it)
            }
        }
    }

    private fun onNoMoreData() {
        (refreshView as OnRefreshLoadMoreView).onNoMoreData()
    }

    private fun morData(list: MutableList<T>) {
        (refreshView as OnRefreshLoadMoreView).onMoreData(list)
        upgradePageIndex()
    }
}