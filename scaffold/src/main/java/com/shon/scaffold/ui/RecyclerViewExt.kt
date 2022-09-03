package com.shon.scaffold.ui

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:42
 *
 */

fun RecyclerView.setLinearLayout(
    mAdapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>,
    layoutManagerSetting: LinearLayoutManager.() -> Unit = {}
): RecyclerView {

    val layoutManager = LinearLayoutManager(context)
    layoutManager.layoutManagerSetting()
    return setLayout(mAdapter, layoutManager)
}

fun RecyclerView.setGradeLayout(
    mAdapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>,
    layoutManagerSetting: () -> GridLayoutManager
) :RecyclerView{
    return setLayout(mAdapter, layoutManagerSetting.invoke())
}

fun RecyclerView.setLayout(
    mAdapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>,
    mLayoutManager: RecyclerView.LayoutManager
): RecyclerView {
    adapter = mAdapter
    layoutManager = mLayoutManager
    return this
}

//fun RecyclerView.bind(
//    mAdapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>,
//    mLayoutManager: RecyclerView.LayoutManager,
//    hasFixSize: Boolean = true,
//    isScroll: Boolean = true
//): RecyclerView {
//    adapter = mAdapter
//    layoutManager = mLayoutManager
////    setHasFixedSize(hasFixSize)
//    isNestedScrollingEnabled = isScroll
//    return this
//}