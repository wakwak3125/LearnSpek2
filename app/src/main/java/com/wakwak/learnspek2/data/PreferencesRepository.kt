package com.wakwak.learnspek2.data

import android.content.SharedPreferences
import io.reactivex.Single
import javax.inject.Inject

class PreferencesRepository @Inject constructor(private val preferences: SharedPreferences,
                                                private val editor: SharedPreferences.Editor) {

    fun getLastFetchedUser(): Single<String> = Single.just(
            preferences.getString("lastFetchedUser", "wakwak3125")
    )

    fun saveFetchTargetUser(name: String): Single<String> = Single.create {
        if (name.isEmpty()) {
            it.onError(IllegalArgumentException("Name is empty"))
        } else {
            editor.putString("lastFetchedUser", name).apply()
            it.onSuccess(getLastFetchedUser().blockingGet())
        }
    }
}
