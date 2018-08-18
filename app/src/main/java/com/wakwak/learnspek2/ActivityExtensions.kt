package com.wakwak.learnspek2

import android.app.Activity
import com.wakwak.learnspek2.di.component.AppComponent

fun Activity.inject(inject: (AppComponent) -> Unit) {
    inject.invoke((application as MyApplication).appComponent)
}
