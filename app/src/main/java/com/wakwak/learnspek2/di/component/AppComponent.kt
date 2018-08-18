package com.wakwak.learnspek2.di.component

import com.wakwak.learnspek2.MyApplication
import com.wakwak.learnspek2.di.module.AppModule
import com.wakwak.learnspek2.di.module.DataModule
import com.wakwak.learnspek2.di.module.InfraModule
import com.wakwak.learnspek2.di.module.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    InfraModule::class,
    DataModule::class
])
interface AppComponent {

    fun inject(application: MyApplication)

    fun plus(module: MainModule): MainComponent
}
