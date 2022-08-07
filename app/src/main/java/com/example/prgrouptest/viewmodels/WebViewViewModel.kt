package com.example.prgrouptest.viewmodels

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prgrouptest.repositories.Repository
import com.example.prgrouptest.repositories.RepositoryImpl
import kotlinx.coroutines.launch

class WebViewViewModel(activity: Activity) : ViewModel() {

    private var _url = MutableLiveData<String>()
    val url: LiveData<String> = _url

    private var repository: Repository = RepositoryImpl(activity)

    fun saveUrl(url: String) {
        viewModelScope.launch {
            repository.saveUrl(url)
        }
    }

    fun getUrl() {
        viewModelScope.launch {
            val result = repository.getUrl()
            _url.value = result
        }

    }

}