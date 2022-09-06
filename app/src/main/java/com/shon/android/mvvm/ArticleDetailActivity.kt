package com.shon.android.mvvm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.shon.android.mvvm.databinding.ActivityArticleDetailBinding
import com.shon.mvvm.BaseViewModel
import com.shon.scaffold.ui.doubleClick
import com.shon.web.BaseWebActivity

class ArticleDetailActivity : BaseWebActivity<BaseViewModel,ActivityArticleDetailBinding>() {
    companion object{
        fun showArticleDetail(context: Context,url:String){
            val intent = Intent(context,ArticleDetailActivity::class.java)
            intent.putExtra("url",url)
            context.startActivity(intent)
        }
    }
    override fun transparentStatusBar(): Boolean {
        return true
    }

    override fun darkStatusBar(): Boolean {
        return true
    }
    override fun getWebContainer(): ViewGroup? {
        return viewBinding.webContainer
    }

    override fun getWebUrl(): String? {
        return intent.getStringExtra("url")
    }

    override fun setPageFinished(title: String?, url: String?) {
        title?.let {
            viewBinding.title.text = it
        }
    }
    override fun onInitListener() {
        viewBinding.backImage.doubleClick {
            finish()
        }
    }



}