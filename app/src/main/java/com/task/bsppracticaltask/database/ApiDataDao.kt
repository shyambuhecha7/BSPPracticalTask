package com.task.bsppracticaltask.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ApiDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApiData(apiData: ApiDataEntity)

    @Query("SELECT * FROM book_data WHERE request_uuid = :requestUuid")
    suspend fun getBookData(requestUuid: String): ApiDataEntity?

    @Query("DELETE FROM book_data")
    suspend fun clearBookApiData()
}