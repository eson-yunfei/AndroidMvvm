package com.shon.scaffold.refresh

import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.shon.scaffold.databinding.LayoutRefreshBinding
import com.shon.scaffold.databinding.LayoutRefreshLoadMoreBinding
import com.shon.scaffold.ui.setLayout

/**
 *
 * @Author xiao
 * @Data 2022-09-03 10:36
 */

fun <T> LayoutRefreshBinding.initLayoutWithViewModel(
    viewModel: BaseRefreshViewModel<T, *>,
    adapter: BaseQuickAdapter<T, *>,
    layoutManager: RecyclerView.LayoutManager,
    refresh: () -> Unit,
) {
    this.recyclerView.setLayout(adapter, layoutManager)
    this.smartRefreshLayout.setRefreshListener(refresh)

    viewModel.setOnRefreshView(object : OnRefreshView<T> {
        override fun onNoData() {
            smartRefreshLayout.finishRefresh(true)
            adapter.setNewInstance(mutableListOf())
        }

        override fun onRefreshData(data: MutableList<T>) {
            smartRefreshLayout.finishRefresh(true)
            adapter.setNewInstance(data)
        }

    })
}

fun <T> LayoutRefreshLoadMoreBinding.initLayoutWithViewModel(
    viewModel: BaseRefreshLoadMoreViewModel<T, *>,
    adapter: BaseQuickAdapter<T, *>,
    layoutManager: RecyclerView.LayoutManager,
    refresh: () -> Unit,
    loadMore: () -> Unit
) {
    this.recyclerView.setLayout(adapter, layoutManager)
    this.smartRefreshLayout.setAllListener(refresh, loadMore)

    viewModel.setOnRefreshLoadMoreView(object : OnRefreshLoadMoreView<T> {
        override fun onNoMoreData() {
            smartRefreshLayout.setNoMoreData(true)
        }

        override fun onMoreData(data: MutableList<T>) {
            smartRefreshLayout.finishLoadMore(true)
            adapter.addData(data)
        }

        override fun onNoData() {
            smartRefreshLayout.finishRefresh(true)
            adapter.setNewInstance(mutableListOf())
        }

        override fun onRefreshData(data: MutableList<T>) {
            smartRefreshLayout.finishRefresh(true)
            adapter.setNewInstance(data)
        }

    })
}