package com.shon.android.mvvm

import androidx.recyclerview.widget.LinearLayoutManager
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener
import com.shon.android.mvvm.adapter.ArticleAdapter
import com.shon.android.mvvm.databinding.ActivityMainBinding
import com.shon.android.mvvm.viewmodels.MainViewModel
import com.shon.mvvm.activity.BaseVmVbActivity
import com.shon.picture.engine.GlideEngine
import com.shon.scaffold.adapter.itemDoubleClick
import com.shon.scaffold.refresh.initLayoutWithViewModel
import org.eson.slog.logD

class MainActivity : BaseVmVbActivity<MainViewModel, ActivityMainBinding>() {

    private val articleAdapter: ArticleAdapter = ArticleAdapter(mutableListOf())

    val testImageUrl: String =
        "https://c-ssl.duitang.com/uploads/item/201710/17/20171017215814_fwPMQ.jpeg"
    override fun onInitView() {
        super.onInitView()
        viewBinding.listLayout.initLayoutWithViewModel(
            viewModel, articleAdapter,
            LinearLayoutManager(this), refresh = {
                viewModel.startRefreshData()
            }, loadMore = {
                viewModel.startLoadMoreData()
            })
    }

    override fun onInitListener() {

        articleAdapter.itemDoubleClick { item, position ->
            logD("item click  position = $position")
            val localMedia = LocalMedia()
            localMedia.realPath = testImageUrl
            localMedia.path = testImageUrl
            PictureSelector.create(this)
                .openPreview()
                .setImageEngine(GlideEngine.engine)
                .setExternalPreviewEventListener(object : OnExternalPreviewEventListener {
                    override fun onPreviewDelete(position: Int) {

                    }

                    override fun onLongPressDownload(media: LocalMedia?): Boolean {
                        return false
                    }

                })
                .startActivityPreview(1,false,
                    arrayListOf(localMedia,localMedia)
                )
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