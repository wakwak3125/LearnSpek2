package com.wakwak.learnspek2.domain

import com.wakwak.learnspek2.data.GitHubUserRepository
import com.wakwak.learnspek2.data.PreferencesRepository
import io.reactivex.Single
import okhttp3.ResponseBody
import javax.inject.Inject

class GetGitHubUserUseCase @Inject constructor(val gitHubUserRepository: GitHubUserRepository,
                                               val sharedPreferencesRepository: PreferencesRepository) {

    fun execute(): Single<ResponseBody> =
            sharedPreferencesRepository.getLastFetchedUser()
                    .flatMap { gitHubUserRepository.get(it) }
}
