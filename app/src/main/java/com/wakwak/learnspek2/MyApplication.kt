package com.wakwak.learnspek2

import android.app.Application
import android.os.Looper
import com.wakwak.learnspek2.di.component.AppComponent
import com.wakwak.learnspek2.di.component.DaggerAppComponent
import com.wakwak.learnspek2.di.module.AppModule
import com.wakwak.learnspek2.di.module.DataModule
import com.wakwak.learnspek2.di.module.InfraModule
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .infraModule(InfraModule())
                .dataModule(DataModule(this))
                .build()
        appComponent.inject(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            AndroidSchedulers.from(Looper.getMainLooper(), true)
        }
    }
}
