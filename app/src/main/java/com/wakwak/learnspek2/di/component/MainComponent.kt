package com.wakwak.learnspek2.di.component

import com.wakwak.learnspek2.MainActivity
import com.wakwak.learnspek2.di.module.MainModule
import com.wakwak.learnspek2.di.scope.PresentationScope
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [
    MainModule::class
])
interface MainComponent {
    fun inject(activity: MainActivity)
}
