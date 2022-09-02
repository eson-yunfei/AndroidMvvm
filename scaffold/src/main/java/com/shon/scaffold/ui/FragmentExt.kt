package com.shon.scaffold.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import org.eson.slog.logD

/**
 *
 * @Author xiao
 * @Date 2022-08-26 12:19
 *
 */

fun AppCompatActivity.replaceFragment(
    resourceId: Int,
    currentFragment: Fragment?,
    needShowFragment: Fragment?,
    tag: String
): Fragment? {
    logD("need show tag :  $tag,  fragment: $needShowFragment")
    val transaction = supportFragmentManager.beginTransaction()
    return transaction.replaceFragment(resourceId, currentFragment, needShowFragment, tag)

}

fun Fragment.replaceFragment(
    resourceId: Int,
    currentFragment: Fragment?,
    needShowFragment: Fragment?,
    tag: String
): Fragment? {
    logD("need show tag :  $tag,  fragment: $needShowFragment")
    val transaction = childFragmentManager.beginTransaction()
    return transaction.replaceFragment(resourceId, currentFragment, needShowFragment, tag)
}

private fun FragmentTransaction.replaceFragment(
    resourceId: Int,
    currentFragment: Fragment?,
    needShowFragment: Fragment?,
    tag: String
): Fragment? {

    if (currentFragment == needShowFragment) {
        return currentFragment
    }
    currentFragment?.let { hide(it) }
    needShowFragment?.let {
        if (it.isAdded) {
            show(it).commitAllowingStateLoss()
        } else {
            add(resourceId, it, tag).show(it)
                .commitAllowingStateLoss()
        }
    }

    return needShowFragment
}