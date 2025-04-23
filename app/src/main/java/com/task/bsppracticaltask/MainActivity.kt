package com.task.bsppracticaltask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.task.bsppracticaltask.api.ApiService
import com.task.bsppracticaltask.database.AppDatabase
import com.task.bsppracticaltask.repository.ApiRepository
import com.task.bsppracticaltask.ui.viewmodel.MainViewModel
import com.task.bsppracticaltask.ui.screens.ApiDataScreen
import com.task.bsppracticaltask.ui.theme.BSPPracticalTaskTheme
import com.task.bsppracticaltask.ui.viewmodel.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BSPPracticalTaskTheme {
//                    val apiService = Retrofit.Builder()
//                        .baseUrl("https://practical.mytdigital.tech/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build()
//                        .create(ApiService::class.java)
//
//                    val database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app_db").build()
//                    val apiRepository = ApiRepository(apiService, database.apiDataDao())
//                    viewModel = ViewModelProvider(this, ViewModelFactory(apiRepository)).get(
//                        MainViewModel::class.java)

                val viewModel = hiltViewModel<MainViewModel>()
                    ApiDataScreen(viewModel)
            }
        }
    }
}

