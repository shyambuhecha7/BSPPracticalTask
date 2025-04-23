package com.task.bsppracticaltask.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.task.bsppracticaltask.model.ApiResponse
import com.task.bsppracticaltask.ui.components.AudiobookList
import com.task.bsppracticaltask.ui.components.CarouselSection
import com.task.bsppracticaltask.ui.components.ClassicSection
import com.task.bsppracticaltask.ui.components.FeaturesSection
import com.task.bsppracticaltask.ui.viewmodel.MainViewModel

@Composable
fun ApiDataScreen(viewModel: MainViewModel) {
    val apiResponse: ApiResponse? by viewModel.apiResponse.observeAsState()
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
}


//









