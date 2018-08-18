package com.wakwak.learnspek2.presentation

import android.support.annotation.StringRes

interface IView {

    fun showMessage(@StringRes message: Int)

    fun showMessage(message: String)
}
