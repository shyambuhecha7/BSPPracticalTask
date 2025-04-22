package com.task.bsppracticaltask.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ApiDataEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun apiDataDao(): ApiDataDao
}
