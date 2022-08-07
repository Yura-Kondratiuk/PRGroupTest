package com.example.prgrouptest.viewmodels

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prgrouptest.repositories.Repository
import com.example.prgrouptest.repositories.RepositoryImpl
import kotlinx.coroutines.launch

class PrivacyPolicyViewModel(activity: Activity) : ViewModel() {

    private var repository: Repository = RepositoryImpl(activity)

    fun saveUserAgreed() {
        viewModelScope.launch {
            repository.saveUserAgreed()
        }
    }
}