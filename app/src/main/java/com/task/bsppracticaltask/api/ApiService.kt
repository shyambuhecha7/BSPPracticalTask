package com.task.bsppracticaltask.api

import com.task.bsppracticaltask.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("testdiscovery/")
    suspend fun getApiResponse(): ApiResponse
}
