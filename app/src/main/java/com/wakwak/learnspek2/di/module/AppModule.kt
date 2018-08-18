package com.wakwak.learnspek2.di.module

import android.content.Context
import com.wakwak.learnspek2.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: MyApplication) {

    @Singleton
    @Provides
    fun providesContext(): Context = application.applicationContext
}
