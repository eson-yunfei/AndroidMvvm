package com.shon.android.mvvm.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.shon.android.mvvm.R
import com.shon.android.mvvm.databinding.ItemArticleBinding
import com.shon.android.net.response.ArticleBean
import com.shon.scaffold.ui.toTimeString


class ArticleAdapter(data: MutableList<ArticleBean>) :
    BaseQuickAdapter<ArticleBean, BaseViewHolder>(
        R.layout.item_article, data
    ) {
    override fun convert(holder: BaseViewHolder, item: ArticleBean) {
        val bind = ItemArticleBinding.bind(holder.itemView)
        bind.titleTv.text = item.title
        bind.userNameTv.text = item.shareUser
        val toTimeString = item.publishTime.toTimeString("yyyy/MM/dd HH:mm")
        bind.createTimeTv.text = toTimeString
    }
}