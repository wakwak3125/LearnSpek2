package com.wakwak.learnspek2.data

import com.wakwak.learnspek2.infra.GitHubService
import javax.inject.Inject

class GitHubUserRepository @Inject constructor(private val gitHubService: GitHubService) {

    fun get(name: String) = gitHubService.getGitHubUser(name)
}
