package com.shon.scaffold.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 *
 * @Author xiao
 * @Date 2022-09-02 16:10
 *
 */

/**
 * 是否为手机号  0开头 12开头的不支持
 */
fun String?.isPhone(): Boolean {
    return this?.let {
        Pattern.matches(it, "0?(13|14|15|16|17|18|19)[0-9]{9}")
    } ?: let {
        false
    }
}

fun String?.isEmail2(): Boolean {
    this ?: return false
    val str = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$"
    val p: Pattern = Pattern.compile(str)
    val m: Matcher = p.matcher(this)
    return m.matches()
}

/**
 * 是否为邮箱号
 */
fun String?.isEmail(): Boolean {
    return this?.let {
        Pattern.matches(this, "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\$")
    } ?: let {
        false
    }
}

/**
 * 将字符串中的连续的多个换行缩减成一个换行
 * @return    返回的结果
 */
fun String.replaceLineBlanks(): String {
    val p = Pattern.compile("(\r?\n(\\s*\r?\n)+)");
    val m: Matcher = p.matcher(this);
    val result = m.replaceAll("\r\n");
    return result
}
