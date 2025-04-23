package com.task.bsppracticaltask.di

import android.content.Context
import androidx.room.Room
import com.task.bsppracticaltask.api.ApiService
import com.task.bsppracticaltask.database.ApiDataDao
import com.task.bsppracticaltask.database.AppDatabase
import com.task.bsppracticaltask.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://practical.mytdigital.tech/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_db").allowMainThreadQueries().build()

    }

    @Provides
    fun provideAppDao(appDatabase: AppDatabase):  ApiDataDao{
        return appDatabase.apiDataDao()

    }
    @Provides
    fun provideRepository(apiService: ApiService,apiDataDao: ApiDataDao): ApiRepository {
        return ApiRepository(apiService,apiDataDao)
    }

}