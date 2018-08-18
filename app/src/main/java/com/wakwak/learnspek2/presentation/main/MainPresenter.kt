package com.wakwak.learnspek2.presentation.main

import com.wakwak.learnspek2.domain.GetGitHubUserUseCase
import com.wakwak.learnspek2.presentation.IPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor(private val getGitHubUserUseCase: GetGitHubUserUseCase) : IPresenter<MainView> {

    private lateinit var view: MainView
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: MainView) {
        this.view = view
    }

    override fun detach() {
        compositeDisposable.clear()
    }

    fun getGitHubUser() {
        val disposable = getGitHubUserUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showGitHubUser(it.string())
                }, {
                    view.showMessage(it.message ?: "Error")
                })
        compositeDisposable.add(disposable)
    }
}
