package com.task.bsppracticaltask.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.task.bsppracticaltask.repository.ApiRepository


class ViewModelFactory(
    private val apiRepository: ApiRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(apiRepository) as T
    }
}