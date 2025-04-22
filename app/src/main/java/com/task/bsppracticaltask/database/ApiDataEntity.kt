package com.task.bsppracticaltask.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_data")
data class ApiDataEntity(
    @PrimaryKey val request_uuid: String,
    val success: Boolean,
    val api_log_id: Long,
    val generated: String,
    val page: String,
    val timestamp: Long
)

