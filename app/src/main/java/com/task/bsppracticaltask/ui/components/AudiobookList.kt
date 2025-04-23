package com.task.bsppracticaltask.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.task.bsppracticaltask.model.Element
import com.task.bsppracticaltask.ui.theme.Gray

@Composable
fun AudiobookList(element: Element?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                element?.header ?: "New Audiobooks",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                ),
                modifier = Modifier
                    .weight(0.7f)
                    .padding(end = 8.dp)
            )
            Text(
                "See all",
                style = MaterialTheme.typography.labelLarge.copy(color = Color(0xFF00897B)),
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { }
            )


        }

        data class Book(val title: String, val author: String)

        val audiobooks = listOf(
            Book("Dragonwatch: Return of the Dragon Slayers", "Brandon Mull"),
            Book("The Divine Gift of Forgiveness", "Neil L. Andersen"),
            Book("Fablehaven", "Brandon Mull")
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Gray),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            audiobooks.forEach { (title, author) ->
                element?.component_items?.get(0)?.media_data?.cover?.full_url?.let {
                    AudiobookItem(
                        title, author,
                        it
                    )
                }
            }
        }
    }
}

@Composable
fun AudiobookItem(title: String, author: String, imageRes: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        AsyncImage(
            model = imageRes,
            contentDescription = title,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
            Text(author, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}