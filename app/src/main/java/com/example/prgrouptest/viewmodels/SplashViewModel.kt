package com.example.prgrouptest.viewmodels

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prgrouptest.repositories.Repository
import com.example.prgrouptest.repositories.RepositoryImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(activity: Activity) : ViewModel() {

    private var _isUserAgreed = MutableLiveData<Boolean>()
    val isUserAgreed: LiveData<Boolean> = _isUserAgreed

    private var repository: Repository = RepositoryImpl(activity)

    fun isUserAgreed() {
        viewModelScope.launch {
            delay(1000)
            val result = repository.isUserAgreed()
            _isUserAgreed.value = result
        }
    }

}