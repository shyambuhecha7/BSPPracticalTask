package com.task.bsppracticaltask.repository

import com.google.gson.Gson
import com.task.bsppracticaltask.api.ApiService
import com.task.bsppracticaltask.database.ApiDataDao
import com.task.bsppracticaltask.database.ApiDataEntity
import com.task.bsppracticaltask.model.ApiResponse
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService, private val apiDataDao: ApiDataDao) {

    suspend fun fetchDataFromApi(): ApiResponse? {
        val response = apiService.getApiResponse()
        response?.let {
            val apiDataEntity = ApiDataEntity(
                request_uuid = it.request_uuid,
                success = it.success,
                api_log_id = it.api_log_id,
                generated = it.generated,
                page = Gson().toJson(it.page),
                timestamp = System.currentTimeMillis()
            )
            apiDataDao.insertApiData(apiDataEntity)
        }
        return response
    }

    suspend fun getLocalData(requestUuid: String): ApiDataEntity? {
        return apiDataDao.getBookData(requestUuid)
    }
}
