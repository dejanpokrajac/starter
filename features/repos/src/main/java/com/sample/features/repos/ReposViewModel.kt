package com.sample.features.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.common.base.BaseViewModel
import com.sample.common.util.Event
import com.sample.data.model.Repo
import com.sample.data.repository.AppDispatchers
import com.sample.data.repository.ReposRepository
import com.sample.data.repository.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReposViewModel(private val repository: ReposRepository,
                     private val dispatchers: AppDispatchers) : BaseViewModel() {

    private val _repos = MediatorLiveData<Resource<List<Repo>>>()
    val repos: LiveData<Resource<List<Repo>>> get() = _repos
    private var reposSource: LiveData<Resource<List<Repo>>> = MutableLiveData()

    init {
        getRepos(false)
    }

    fun onRefresh() = getRepos(true)

    private fun getRepos(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
        _repos.removeSource(reposSource)
        withContext(dispatchers.io) {
            reposSource = repository.getRepos(forceRefresh = forceRefresh)
        }
        _repos.addSource(reposSource) {
            _repos.value = it
            if (it.status == Resource.Status.ERROR) {
                _errorHandler.value =
                    Event(R.string.generic_error)
            }
        }
    }
}