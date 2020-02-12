package com.sample.features.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.common.base.BaseViewModel
import com.sample.common.util.Event
import com.sample.data.model.User
import com.sample.data.repository.AppDispatchers
import com.sample.data.repository.UserRepository
import com.sample.data.repository.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(
    private val repository: UserRepository,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    private var userSource: LiveData<Resource<User>> = MutableLiveData()

    private val _user = MediatorLiveData<User>()
    val user: LiveData<User> get() = _user
    private val _isLoading = MutableLiveData<Resource.Status>()
    val isLoading: LiveData<Resource.Status> get() = _isLoading

    init {
        getUser(false)
    }

    fun onRefresh() = getUser(true)

    private fun getUser(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
        _user.removeSource(userSource)
        withContext(dispatchers.io) {
            userSource = repository.getUser(forceRefresh = forceRefresh)
        }
        _user.addSource(userSource) {
            _user.value = it.data
            _isLoading.value = it.status
            if (it.status == Resource.Status.ERROR) {
                _errorHandler.value =
                    Event(R.string.generic_error)
            }
        }
    }
}