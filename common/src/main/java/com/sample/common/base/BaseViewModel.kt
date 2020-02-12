package com.sample.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.common.util.Event

abstract class BaseViewModel : ViewModel() {
    protected val _errorHandler = MutableLiveData<Event<Int>>()
    val errorHandler: LiveData<Event<Int>> get() = _errorHandler

}