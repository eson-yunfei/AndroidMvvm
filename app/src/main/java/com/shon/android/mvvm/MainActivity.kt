package com.shon.android.mvvm

import androidx.recyclerview.widget.LinearLayoutManager
import com.shon.android.mvvm.adapter.ArticleAdapter
import com.shon.android.mvvm.databinding.ActivityMainBinding
import com.shon.android.mvvm.viewmodels.MainViewModel
import com.shon.mvvm.activity.BaseVmVbActivity
import com.shon.scaffold.adapter.itemDoubleClick
import com.shon.scaffold.refresh.initLayoutWithViewModel

class MainActivity : BaseVmVbActivity<MainViewModel, ActivityMainBinding>() {

    private val articleAdapter: ArticleAdapter = ArticleAdapter(mutableListOf())

    override fun onInitView() {
        viewBinding.listLayout.initLayoutWithViewModel(
            viewModel, articleAdapter,
            LinearLayoutManager(this), {
                viewModel.startRefreshData()
            }, {
                viewModel.startLoadMoreData()
            })
    }
    override fun onInitListener() {

        articleAdapter.itemDoubleClick { item, position ->

        }
    }

    override fun onInitData() {
        viewBinding.listLayout.smartRefreshLayout.autoRefresh(100)
    }

    override fun transparentStatusBar(): Boolean {
        return true
    }

    override fun darkStatusBar(): Boolean {
        return true
    }
}