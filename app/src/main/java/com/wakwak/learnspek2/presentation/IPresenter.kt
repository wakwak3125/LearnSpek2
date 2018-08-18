package com.wakwak.learnspek2.presentation

interface IPresenter<V : IView> {

    fun attach(view: V)

    fun detach()
}
