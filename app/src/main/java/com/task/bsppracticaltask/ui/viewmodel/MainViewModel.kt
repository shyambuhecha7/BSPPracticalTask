package com.task.bsppracticaltask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.task.bsppracticaltask.model.ApiResponse
import com.task.bsppracticaltask.repository.ApiRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState<ApiResponse>>()
    val uiState: LiveData<UiState<ApiResponse>> = _uiState

    fun fetchData(requestUuid: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val localData = repository.getLocalData(requestUuid)
                val response = if (localData != null
                    && (System.currentTimeMillis() - localData.timestamp) < 2 * 60 * 60 * 1000
                ) {
                    Gson().fromJson(localData.page, ApiResponse::class.java)
                } else {
                    repository.fetchDataFromApi() ?: throw Exception("Empty API response")
                }
                _uiState.value = UiState.Success(response)
            } catch (t: Throwable) {
                _uiState.value = UiState.Error(
                    t.localizedMessage ?: "Unknown error occurred"
                )
            }
        }
    }
}

