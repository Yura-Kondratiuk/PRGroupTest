package com.example.prgrouptest.data

import android.app.Activity
import android.content.Context

class WebViewPreference(activity: Activity) {

    private val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
    private val defaultUrl = "https://www.google.com/"

    fun saveUrl(url: String) {
        with(sharedPref.edit()) {
            putString(URL_KEY, url)
            commit()
        }
    }

    fun getUrl(): String = sharedPref.getString(URL_KEY, defaultUrl).toString()

    companion object {
        private const val URL_KEY = "URL_KEY"
    }
}