package com.wakwak.learnspek2.presentation.main

import com.wakwak.learnspek2.presentation.IView

interface MainView : IView {

    fun showGitHubUser(json: String)
}
