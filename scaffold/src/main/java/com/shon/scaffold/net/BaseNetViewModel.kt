package com.shon.scaffold.net

import com.shon.mvvm.BaseViewModel

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:53
 *
 */
abstract class BaseNetViewModel<API> : BaseViewModel(), NetRequest<API> {

}