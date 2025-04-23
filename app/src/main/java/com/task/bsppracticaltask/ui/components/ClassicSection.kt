package com.task.bsppracticaltask.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.task.bsppracticaltask.model.Element

@Composable
fun ClassicSection(element: Element?) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = element?.header ?: "Recommended for you",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                ),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "See all",
                color = Color(0xFF0F8079
                ),
                modifier = Modifier.clickable {}
            )
        }

        Text(
            text = element?.subheader ?: "Based on your recent activity",
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Bold,
                lineHeight = 20.sp
            ), color = Color.Black,
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) {
                AsyncImage(
                    model = element?.component_items?.get(0)?.media_data?.cover?.full_url,
                    contentDescription = "",
                    modifier = Modifier
                        .width(140.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

