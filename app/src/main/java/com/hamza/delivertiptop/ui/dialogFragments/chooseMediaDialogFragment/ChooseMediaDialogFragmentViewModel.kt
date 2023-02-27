package com.hamza.delivertiptop.ui.dialogFragments.chooseMediaDialogFragment

import android.net.Uri
import com.hamza.delivertiptop.ui.base.BaseViewModel

class ChooseMediaDialogFragmentViewModel : BaseViewModel() {
    var mImageUri: MutableList<Uri> = ArrayList()
    var mRequestCode: Int = -1
    var viewType = 0
    var limitOfPickImage = 1
}