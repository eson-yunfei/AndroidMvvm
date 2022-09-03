package com.shon.picture

import android.app.Activity
import com.luck.picture.lib.basic.PictureSelectionModel
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import java.util.ArrayList

/**
 *
 * @Author xiao
 * @Data 2022-09-03 14:21
 */

fun openSystemGallery(activity: Activity, onSelect: (MutableList<String>) -> Unit) {
    PictureSelector.create(activity)
        .openGallery(SelectMimeType.TYPE_IMAGE)
        .openSelector(onSelect)

}

fun PictureSelectionModel.openSelector(onSelect: (MutableList<String>) -> Unit) {
    forResult(object : OnResultCallbackListener<LocalMedia> {
        override fun onResult(result: ArrayList<LocalMedia>?) {
            result?.let {
                onSelect.invoke(it.getFilePath(false))
            }
        }

        override fun onCancel() {
        }

    })
}

fun ArrayList<LocalMedia>.getFilePath(isCrop: Boolean): MutableList<String> {
    val list: MutableList<String> = mutableListOf()
    this.forEach {
        if (isCrop) {
            list.add(it.cutPath)
        } else {
            list.add(it.realPath)
        }
    }
    return list
}
