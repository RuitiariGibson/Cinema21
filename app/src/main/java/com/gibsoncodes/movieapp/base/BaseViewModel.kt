package com.gibsoncodes.movieapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

abstract class BaseViewModel:ViewModel() {
inline fun <T> launchOnViewModelScope(crossinline body: suspend () -> LiveData<T>): LiveData<T> {
    return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emitSource(body())
    }
}
}