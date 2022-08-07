package com.example.prgrouptest.repositories

import android.app.Activity
import com.example.prgrouptest.data.UserAgreedPreference
import com.example.prgrouptest.data.WebViewPreference

class RepositoryImpl(activity: Activity): Repository {

    private var userAgreedPreference: UserAgreedPreference = UserAgreedPreference(activity)
    private var webViewPreference: WebViewPreference = WebViewPreference(activity)

    override suspend fun saveUserAgreed() {
        userAgreedPreference.saveUserAgreed()
    }

    override suspend fun isUserAgreed(): Boolean {
        return userAgreedPreference.isUserAgreed()
    }

    override suspend fun saveUrl(url: String) {
        webViewPreference.saveUrl(url)
    }

    override suspend fun getUrl(): String {
        return webViewPreference.getUrl()
    }

}