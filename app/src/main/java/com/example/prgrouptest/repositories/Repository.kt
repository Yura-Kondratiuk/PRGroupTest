package com.example.prgrouptest.repositories

interface Repository {

    suspend fun saveUserAgreed()

    suspend fun isUserAgreed(): Boolean

    suspend fun saveUrl(url: String)

    suspend fun getUrl(): String
}