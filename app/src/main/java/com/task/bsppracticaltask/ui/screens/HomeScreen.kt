package com.task.bsppracticaltask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.task.bsppracticaltask.model.ApiResponse
import com.task.bsppracticaltask.ui.components.AudiobookList
import com.task.bsppracticaltask.ui.components.CarouselSection
import com.task.bsppracticaltask.ui.components.ClassicSection
import com.task.bsppracticaltask.ui.components.FeaturesSection
import com.task.bsppracticaltask.ui.viewmodel.MainViewModel
import com.task.bsppracticaltask.ui.viewmodel.UiState

@Composable
fun ApiDataScreen(viewModel: MainViewModel) {
//    val apiResponse: ApiResponse? by viewModel.apiResponse.observeAsState()
//    val loading by viewModel.loading.observeAsState(false)
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->

        LaunchedEffect(Unit) {
            viewModel.fetchData(
                System.currentTimeMillis().toString()
            ) //Unique for request data
        }

        val uiState by viewModel.uiState.observeAsState(UiState.Loading)

        when (uiState) {
            is UiState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Success<*> -> {
                val apiResponse = (uiState as UiState.Success<ApiResponse>).data

                MainContent(paddingValues, apiResponse)

            }

            is UiState.Error -> {
                val message = (uiState as UiState.Error).message
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Something went wrong:\n$message",
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(16.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        Button(onClick = {
                            viewModel.fetchData(
                                System.currentTimeMillis().toString()
                            )
                        }) {
                            Text("Retry")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues,
    apiResponse: ApiResponse
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = apiResponse?.page?.elements?.get(0)?.mobile_image_url,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.FillWidth
        )

        HorizontalDivider(
            modifier = Modifier
                .height(2.dp)
                .padding(16.dp),
            color = Color.Black.copy(alpha = 0.1f)
        )

        Spacer(modifier = Modifier.height(16.dp))
        //element_type : "carousel"

        CarouselSection(apiResponse?.page?.elements?.get(3))

        Spacer(modifier = Modifier.height(16.dp))
        //element_type : "classic"

        ClassicSection(apiResponse?.page?.elements?.get(1))

        Spacer(modifier = Modifier.height(16.dp))

        FeaturesSection(apiResponse?.page?.elements?.get(2))

        Spacer(modifier = Modifier.height(16.dp))

        AudiobookList(apiResponse?.page?.elements?.get(4))
    }
}


//









