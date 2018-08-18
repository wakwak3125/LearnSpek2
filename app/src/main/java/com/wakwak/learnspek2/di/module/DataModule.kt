package com.wakwak.learnspek2.di.module

import android.content.Context
import android.content.SharedPreferences
import com.wakwak.learnspek2.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule(private val application: MyApplication) {

    @Provides
    @Singleton
    fun providesPreferences(): SharedPreferences =
            application.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providesPreferencesEditor(prefs: SharedPreferences): SharedPreferences.Editor =
            prefs.edit()
}
