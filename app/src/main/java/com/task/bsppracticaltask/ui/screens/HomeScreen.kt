package com.task.bsppracticaltask.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.task.bsppracticaltask.ui.viewmodel.MainViewModel

@Composable
fun ApiDataScreen(viewModel: MainViewModel) {
    val apiResponse by viewModel.apiResponse.observeAsState()
    val loading by viewModel.loading.observeAsState(false)

    LaunchedEffect(Unit) {
        viewModel.fetchData(
            System.currentTimeMillis().toString()
        ) //Unique for request data
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = apiResponse?.page?.elements?.get(0)?.media_data?.cover?.full_url,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
        }

    }

    //For Testing
//    if (loading) {
//        CircularProgressIndicator()
//    } else {
//        apiResponse?.let {
//            Text("Data loaded successfully: ${it.success}")
//            // Display other details of your API response
//        } ?: run {
//            Text("No data available")
//        }
//    }
}
