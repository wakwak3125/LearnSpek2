package com.wakwak.learnspek2.infra

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{name}")
    fun getGitHubUser(@Path("name") name: String): Single<ResponseBody>
}
