package com.geeks.retrofitandroid15.utils

interface CustomCallback<T> {

    fun onResponse(data: T)

    fun onFailure(t: Throwable)
}