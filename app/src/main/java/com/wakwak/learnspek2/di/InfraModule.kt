package com.wakwak.learnspek2.di

import com.squareup.moshi.Moshi
import com.wakwak.learnspek2.infra.GitHubService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val GIT_HUB_ACCEPT_HEADER = "application/vnd.github.v3+json"
private const val GIT_HUB_BASE_URL = "https://api.github.com"

@Module
class InfraModule {

    @Provides
    @Singleton
    fun providesApiClient(moshi: Moshi, okHttpClient: OkHttpClient): GitHubService =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(GIT_HUB_BASE_URL)
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.createWithScheduler(
                                    Schedulers.io()
                            ))
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build()
                    .create(GitHubService::class.java)

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val orig = chain.request()
                        val newRequest = orig.newBuilder()
                                .addHeader("Accept", GIT_HUB_ACCEPT_HEADER)
                                .build()
                        chain.proceed(newRequest)
                    }
                    .build()
}
