package com.shon.mvvm.base.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/4 22:07
 * Package name : com.shon.mvvm.base.activity
 * Des :
 */
internal object BindingUtil {
    /**
     * activity 的 创建方式
     *
     * @param appCompatActivity AppCompatActivity
     * @param <Binding> Binding
     * @return <Binding> Binding
    </Binding></Binding> */
    fun <Binding> createBinding(appCompatActivity: AppCompatActivity): Binding? {
        val layoutInflater = appCompatActivity.layoutInflater
        val viewBindClass = findViewBinding(appCompatActivity)
        return createViewBinding(viewBindClass, layoutInflater)
    }

    /**
     * fragment 的创建方式
     *
     * @param fragment Fragment
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param <Binding> Binding
     * @return Binding
    </Binding> */
    fun <Binding> createBinding(fragment: Fragment, inflater: LayoutInflater,
                                container: ViewGroup?): Binding? {
        val viewBinding = findViewBinding(fragment)
        return createViewBinding(viewBinding, inflater, container)
    }

    /**
     * 找到 ViewBinding 的 class
     *
     * @param object obj : activity 或者 fragment
     * @return Class
     */
    private fun findViewBinding(`object`: Any): Class<out ViewBinding>? {
        val type = `object`.javaClass.genericSuperclass ?: return null
        return if (type is ParameterizedType){
            val types = type.actualTypeArguments
            if (types.isEmpty()) {
                null
            } else types[0] as Class<out ViewBinding>
        }else{
            null
        }

    }

    /**
     * 得到 Binding 的实例
     *
     * @param viewBindingClass Class
     * @param layoutInflater LayoutInflater
     * @param <Binding> Binding
     * @return Binding
    </Binding> */
    @Suppress("UNCHECKED_CAST")
    private fun <Binding> createViewBinding(viewBindingClass: Class<out ViewBinding>?,
                                            layoutInflater: LayoutInflater): Binding? {
        try {
            val method = viewBindingClass!!.getMethod("inflate", LayoutInflater::class.java)
            val viewBinding = method.invoke(viewBindingClass, layoutInflater) as ViewBinding
            return viewBinding as Binding
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 得到 Binding 的实例
     *
     * @param viewBindingClass Class
     * @param layoutInflater LayoutInflater
     * @param container ViewGroup
     * @param <Binding> Binding
     * @return Binding
    </Binding> */
    fun <Binding> createViewBinding(viewBindingClass: Class<out ViewBinding>?,
                                    layoutInflater: LayoutInflater,
                                    container: ViewGroup?): Binding? {
        val method = viewBindingClass!!.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.javaPrimitiveType)
        val viewBinding = method.invoke(viewBindingClass, layoutInflater, container, false) as ViewBinding
        return viewBinding as Binding

    }
}