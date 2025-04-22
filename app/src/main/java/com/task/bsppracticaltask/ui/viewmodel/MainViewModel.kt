package com.task.bsppracticaltask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.task.bsppracticaltask.model.ApiResponse
import com.task.bsppracticaltask.repository.ApiRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: ApiRepository
) : ViewModel() {

    private val _apiResponse = MutableLiveData<ApiResponse?>()
    val apiResponse: LiveData<ApiResponse?> get() = _apiResponse

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    // Fetch data based on time condition
    fun fetchData(requestUuid: String) {
        viewModelScope.launch {
            _loading.value = true
            val localData = repository.getLocalData(requestUuid)

            if (localData != null && (System.currentTimeMillis() - localData.timestamp) < 2 * 60 * 60 * 1000) {
                // If data is less than 2 hours old, use local data
                val cachedResponse = Gson().fromJson(localData.page, ApiResponse::class.java)
                _apiResponse.value = cachedResponse
            } else {
                // If data is older than 2 hours or not available, fetch from API
                val apiResponse = repository.fetchDataFromApi()
                _apiResponse.value = apiResponse
            }
            _loading.value = false
        }
    }
}
