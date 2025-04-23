package com.task.bsppracticaltask.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.task.bsppracticaltask.R
import com.task.bsppracticaltask.model.Element
import com.task.bsppracticaltask.ui.theme.Gray

@Composable
fun FeaturesSection(element: Element?) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = element?.header ?: "Popular in Bookshelf+",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(5) { book ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .width(220.dp)
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .background(Gray)
                            .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AsyncImage(
                            model = element?.component_items?.get(0)?.media_data?.cover?.listing_url ?: R.drawable.ic_book,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )


                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Dragonwatch, Vol. 5: Return of the Dragon Slayers",
                            style = MaterialTheme.typography.titleSmall,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "What does it mean to be \"all in\" the gospel of Jesus Christ in the latter days?",
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = { },
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(text = "Listen now")
                        }
                    }
                }
            }
        }
    }
}

