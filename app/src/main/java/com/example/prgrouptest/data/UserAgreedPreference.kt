package com.example.prgrouptest.data

import android.app.Activity
import android.content.Context

class UserAgreedPreference(private val activity: Activity) {

    private val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)

    fun saveUserAgreed() {
        with(sharedPref.edit()) {
            putBoolean(USER_AGREED_KEY, true)
            apply()
        }
    }

    fun isUserAgreed() = sharedPref.getBoolean(USER_AGREED_KEY, false)

    companion object {
        private const val USER_AGREED_KEY = "USER_AGREED_KEY"
    }
}