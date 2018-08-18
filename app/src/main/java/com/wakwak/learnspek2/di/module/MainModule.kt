package com.wakwak.learnspek2.di.module

import com.wakwak.learnspek2.data.GitHubUserRepository
import com.wakwak.learnspek2.data.PreferencesRepository
import com.wakwak.learnspek2.di.scope.PresentationScope
import com.wakwak.learnspek2.domain.GetGitHubUserUseCase
import com.wakwak.learnspek2.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
@PresentationScope
class MainModule {

    @Provides
    fun providesMainPresenter(useCase: GetGitHubUserUseCase): MainPresenter =
            MainPresenter(useCase)

    @Provides
    fun providesGetGitHubUserUseCase(
            gitHubUserRepository: GitHubUserRepository,
            preferencesRepository: PreferencesRepository

    ): GetGitHubUserUseCase = GetGitHubUserUseCase(
            gitHubUserRepository,
            preferencesRepository
    )
}
