package com.shon.web

import android.graphics.Bitmap
import android.text.TextUtils
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.LinearLayout
import androidx.lifecycle.*
import com.just.agentweb.AgentWeb
import com.just.agentweb.WebViewClient

/**
 *
 * @Author xiao
 * @Date 2022-09-06 15:54
 *
 */
interface WebViewObserver : LifecycleEventObserver {

    var mAgentWeb: AgentWeb?


    fun onObserverCreate() {
        val webContainer = getWebContainer()
        webContainer?:return
        createAgentWeb(webContainer)
        mAgentWeb?.let {
            settingWebAgent(it)
        }
    }

    fun createAgentWeb(webContainer: ViewGroup) {

        val webUrl = getWebUrl()
        if (TextUtils.isEmpty(webUrl)) {
            return
        }
        mAgentWeb = getAgentWeb()
            .setAgentWebParent(webContainer, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .createAgentWeb()
            .ready()
            .go(webUrl)

    }

    fun getAgentWeb():AgentWeb.AgentBuilder
    fun getWebUrl(): String?

    fun settingWebAgent(agentWeb: AgentWeb) {
        val settings: WebSettings = agentWeb.webCreator.webView.settings
        settings.mediaPlaybackRequiresUserGesture = false
        settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        customWebSetting(settings)

        agentWeb.webCreator.webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                setPageStarted(view?.title, view?.url)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                setPageFinished(view?.title, view?.url)
            }
        }
    }

    fun setPageFinished(title: String?, url: String?) {

    }

    fun setPageStarted(title: String?, url: String?) {

    }

    fun customWebSetting(settings: WebSettings) {}

    fun getWebContainer(): ViewGroup?


    fun onObserverResume() {
        mAgentWeb?.webLifeCycle?.onResume()
    }

    fun onObserverPause() {
        mAgentWeb?.webLifeCycle?.onPause()
    }

    fun onObserverDestroy() {
        mAgentWeb?.webLifeCycle?.onDestroy()
    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d("WebViewObserver", "onStateChanged: event = $event")
        when (event) {
            Lifecycle.Event.ON_CREATE -> onObserverCreate()
            Lifecycle.Event.ON_RESUME -> onObserverResume()
            Lifecycle.Event.ON_PAUSE -> onObserverPause()
            Lifecycle.Event.ON_DESTROY -> onObserverDestroy()
            else -> {}
        }
    }
}